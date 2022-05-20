package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.common.SearchObject;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.flightmanagement.flightmanagement.flight.classtype.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ClassFlightRepository classFlightRepository;

    /**
     * Get all flight data of specify airline from database
     * @return
     */
    public List<ResultFlight> getAll(String airlineCode) {
        log.info("Get all flight by airlineCode from database...");

        List<ResultFlight> result = new ArrayList<>();

        List<Flight> list = flightRepository.getFlightByAirlineCode(airlineCode);

        list.forEach(item -> {
            List<ClassFlightManage> classFlightManages = this.classFlightRepository
                    .findByFlightId(item.getFlightId());
            ResultFlight resultFlight = new ResultFlight(item.getName(), item.getFlightCode(),
                    new SimpleDateFormat("yyyy-MM-dd").format(item.getDeparture()), item.getGateId(), item.getQuantityTicket(),
                    item.getTimeDeparture(), item.getTimeArrival(), item.getFlightStatus(),classFlightManages
                    );
            result.add(resultFlight);
        });
        System.out.println(result);
        return result;
    }

    /**
     * Get flight by code
     * @param flightCode
     */
    public Response findByCode(String flightCode) {
        log.info("Execute getByCode method from Flight Service");

        Flight result = flightRepository.findBy(flightCode);

        return result != null ? Response.ok(result)
                : Response.failed(new BusinessException(FlightError.FLIGHT_NOT_EXIST));
    }

    /**
     * Insert new flight object to database
     * @param flight
     * @return
     */
    public Response save(Flight flight) {
        log.info("Execute save method from Airline Service");

        FlightValidator.validate(flight);
        flight.setStatus(Status.ACTIVE);
        flight.setCreatedBy("SYSTEM");
        flight.setLastUpdateBy("SYSTEM");
        flight.setCreatedDate(Date.from(Instant.now()));
        flight.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(flightRepository.save(flight));
    }

    /**
     * Update existing airline in database
     * @param flight
     * @param id
     * @return
     */
    public Response save(Flight flight, Integer id) {

        log.info("Execute update method from Flight Service");

        Flight existFlight = flightRepository.findById(id).get();

        if (Objects.isNull(existFlight)) {
            throw new BusinessException(FlightError.FLIGHT_NOT_EXIST);
        }

        FlightValidator.validate(flight);

        // setting new data for existing object
        existFlight.setName(flight.getName());
        existFlight.setFlightCode(flight.getFlightCode());
        existFlight.setAirlineId(flight.getAirlineId());
        existFlight.setFlightStatus(flight.getFlightStatus());
        existFlight.setDeparture(flight.getDeparture());
        existFlight.setQuantityTicket(flight.getQuantityTicket());
        existFlight.setDeparturePlace(flight.getDeparturePlace());
        existFlight.setDestination(flight.getDestination());
        existFlight.setGateId(flight.getGateId());
        existFlight.setLastUpdateBy("ADMIN");
        existFlight.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(this.save(existFlight));
    }

    /**
     * Delete flight by id
     * @param id
     * @return
     */
    public Response delete(Integer id) {
        log.info("Execute delete method from Flight Service");

        Flight existingFlight = flightRepository.findById(id).get();

        if (Objects.isNull(existingFlight))
            throw new BusinessException(FlightError.FLIGHT_NOT_EXIST);

        existingFlight.setStatus(Status.DISABLED);
        existingFlight.setLastUpdateBy("ADMIN");
        existingFlight.setLastUpdateDate(Date.from(Instant.now()));

        List<ClassFlightManage> classFlightManages = this.classFlightRepository
                .findByFlightId(existingFlight.getFlightId());

        classFlightManages.forEach(c -> {
            c.setStatus(Status.DISABLED);
            c.setLastUpdateBy("ADMIN");
            c.setLastUpdateDate(Date.from(Instant.now()));
            classFlightRepository.save(c);
        });

        flightRepository.save(existingFlight);
        return Response.ok("Deleted flight object: "
                + existingFlight.getAirlineId() + " " + existingFlight.getName());
    }

    /**
     * Get flight by id
     * @param id
     * @return
     */
    public Response get(Integer id) {
        log.info("Execute get method from Airline Service");

        Flight flight = flightRepository.findById(id).get();

        if (Objects.isNull(flight)) {
            throw new BusinessException(FlightError.FLIGHT_NOT_EXIST);
        }

        return Response.ok(flight);
    }

    /**
     * Find status of flight which has code given before
     * @param flightCode
     * @return
     */
    public Response findFlightStatus(String flightCode) {
        log.info("Execute findFlightStatus method from Airline Service");

        FlightStatus flightStatus = flightRepository.findFlightStatus(flightCode);

        if (Objects.isNull(flightStatus)) {
            throw new BusinessException(FlightError.FLIGHT_NOT_EXIST);
        }

        return Response.ok(flightStatus);
    }


    /**
     * Search flight, can be multiple flight
     * @param
     * @return
     */
    public Response searchFlight(String departurePlace, String destination, int quantity,
                                 ClassType classType, String departure) {
        List<SearchObject> flights = flightRepository.searchFlight(departurePlace, destination,
                quantity, classType, departure);

        return flights.isEmpty() ? Response.failed(new BusinessException(FlightError.FLIGHT_NOT_FOUND))
                : Response.ok(flights);
    }


    /**
     * Create new Flight Item
     * @param name
     * @param airlineId
     * @param departure
     * @param departurePlace
     * @param destination
     * @param time
     * @param gateId
     * @param timeDeparture
     * @param timeArrival
     * @param ptPrice
     * @param ptQuantity
     * @param pt_dbPrice
     * @param pt_dbQuantity
     * @param tgPrice
     * @param tgQuantity
     * @param hnPrice
     * @param hnQuantity
     * @return
     * @throws ParseException
     */
    public Response create(String name, int airlineId, String departure, String departurePlace,
                           String destination, int time, String gateId, String timeDeparture,
                           String timeArrival, int ptPrice, int ptQuantity, int pt_dbPrice,
                           int pt_dbQuantity, int tgPrice, int tgQuantity, int hnPrice, int hnQuantity)
            throws ParseException {



        Flight flight = new Flight("newFlight", name, airlineId, FlightStatus.Khoi_Tao,
                new SimpleDateFormat("yyyy-MM-dd").parse(departure),
                ptQuantity + pt_dbQuantity + tgQuantity + hnQuantity,
                departurePlace, destination,
                time, timeDeparture, timeArrival, gateId, Status.ACTIVE, "ADMIN", Date.from(Instant.now()),
                "ADMIN", Date.from(Instant.now()));
        flight.setNew(true);
        FlightValidator.validate(flight);
        flightRepository.save(flight);
        Integer flightId = getFlightIdByFlightCode("newFlight");
        Flight newFlight = flightRepository.findBy("newFlight");
        String flight_code = parsePlace(departurePlace)
                .concat(parsePlace(destination))
                .concat(String.format("%04d", airlineId))
                .concat(String.format("%04d", flightId));
        newFlight.setFlightCode(flight_code);
        flightRepository.save(newFlight);




        String ptCode = String.format("%04d", flightId)
                .concat(changeClassType(ClassType.PHO_THONG));
        String pt_dbCode = String.format("%04d", flightId)
                .concat(changeClassType(ClassType.PHO_THONG_DAC_BIET));
        String tgCode = String.format("%04d", flightId)
                .concat(changeClassType(ClassType.THUONG_GIA));
        String hnCode = String.format("%04d", flightId)
                .concat(changeClassType(ClassType.HANG_NHAT));

        ClassFlightManage ptClass = new ClassFlightManage(
                ClassType.PHO_THONG, ptCode, ptPrice, ptQuantity, ptQuantity, Status.ACTIVE,
                flight.getFlightId(), "ADMIN", Date.from(Instant.now()), "ADMIN",
                Date.from(Instant.now()));

        ClassFlightManage pt_dbClass = new ClassFlightManage(
                ClassType.PHO_THONG_DAC_BIET, pt_dbCode, pt_dbPrice, pt_dbQuantity, pt_dbQuantity, Status.ACTIVE,
                flight.getFlightId(), "ADMIN", Date.from(Instant.now()), "ADMIN",
                Date.from(Instant.now()));

        ClassFlightManage tgClass = new ClassFlightManage(
                ClassType.THUONG_GIA, tgCode, tgPrice, tgQuantity, tgQuantity, Status.ACTIVE,
                flight.getFlightId(), "ADMIN", Date.from(Instant.now()), "ADMIN",
                Date.from(Instant.now()));

        ClassFlightManage hnClass = new ClassFlightManage(
                ClassType.HANG_NHAT, hnCode, hnPrice, hnQuantity, hnQuantity, Status.ACTIVE,
                flight.getFlightId(), "ADMIN", Date.from(Instant.now()), "ADMIN",
                Date.from(Instant.now()));


        ClassFlightValidator.validate(ptClass);
        ClassFlightValidator.validate(pt_dbClass);
        ClassFlightValidator.validate(tgClass);
        ClassFlightValidator.validate(hnClass);

        System.out.println(flight);
        System.out.println(ptClass);
        System.out.println(pt_dbClass);
        System.out.println(tgClass);
        System.out.println(hnClass);

        ptClass.setNew(true);
        pt_dbClass.setNew(true);
        tgClass.setNew(true);
        hnClass.setNew(true);



        classFlightRepository.save(ptClass);
        classFlightRepository.save(pt_dbClass);
        classFlightRepository.save(tgClass);
        classFlightRepository.save(hnClass);

        return Response.ok("Create successfully!");
    }

    /**
     * Parse location code
     * @param place
     * @return
     */
    public String parsePlace (String place) {
        switch (place.substring(0, place.length() - 10)) {
            case "Đà Nẵng": return "DAD";
            case "Hà Nội": return "HAN";
            case "Đà Lạt": return "DLI";
            case "Nha Trang": return "CXR";
            case "Phú Quốc": return "PQC";
            case "Huế": return "HUI";
            case "Vinh": return "VII";
            default: return "SGN";

        }
    }

    /**
     * Parse class type code
     * @param classType
     * @return
     */
    private String changeClassType(ClassType classType) {
        switch (classType) {
            case PHO_THONG: return "PTXX";
            case PHO_THONG_DAC_BIET: return "PTDB";
            case THUONG_GIA: return "TGXX";
            default: return "HNXX";
        }
    }

    /**
     * Get all active flight
     * @return
     */
    public Response getActiveFlight() {
        log.info("Get all active flight from database...");

        List<FlightItem> result = new ArrayList<>();

        Iterable<Flight> flights = flightRepository.getActiveFlight();

        flights.forEach(flight -> {
//            System.out.println(flight);
            List<ClassFlightManage> classFlightManages = this.classFlightRepository
                    .findByFlightId(flight.getFlightId());
//            classFlightManages.forEach(System.out::println);
            Optional<ClassFlightManage> pt = classFlightManages.stream().filter(c ->
                    c.getClassType().equals(ClassType.PHO_THONG)).findFirst();
            Optional<ClassFlightManage> pt_db = classFlightManages.stream().filter(c ->
                    c.getClassType().equals(ClassType.PHO_THONG_DAC_BIET)).findFirst();
            Optional<ClassFlightManage> tg = classFlightManages.stream().filter(c ->
                    c.getClassType().equals(ClassType.THUONG_GIA)).findFirst();
            Optional<ClassFlightManage> hn = classFlightManages.stream().filter(c ->
                    c.getClassType().equals(ClassType.HANG_NHAT)).findFirst();
            FlightItem flightItem = new FlightItem(
                    flight.getName(), flight.getAirlineId(), flight.getDeparture(),
                    flight.getDeparturePlace(), flight.getDestination(), flight.getTime(), flight.getGateId(),
                    flight.getQuantityTicket(), flight.getTimeDeparture(), flight.getTimeArrival(),
                    pt.get().getPrice(), pt.get().getQuantity(),
                    pt_db.get().getPrice(), pt_db.get().getQuantity(),
                    tg.get().getPrice(), tg.get().getQuantity(), hn.get().getPrice(), hn.get().getQuantity());
            result.add(flightItem);
        });
        return Response.ok(result);
    }


    /**
     * Retrieve flight id from flight code
     * @param flightCode
     * @return
     */
    public Integer getFlightIdByFlightCode(String flightCode) {
        return flightRepository.getFlightIdByFlightCode(flightCode);
    }


    /**
     * Update flight status
     * @param flightCode
     * @param flightStatus
     * @return
     */
    public Response updateFlightStatus(String flightCode, FlightStatus flightStatus) {

        Flight flight = flightRepository.findBy(flightCode);
        flight.setFlightStatus(flightStatus);
        flightRepository.save(flight);
        return Response.ok(flightCode);
    }


    /**
     * Statistic flight of airline
     * @param airlineCode
     * @return
     */
    public Response statisticFlight(String airlineCode) {

        List<ResultFlight> list = this.getAll(airlineCode);
        Map<String, List<ResultFlight>> res = list.stream().collect(Collectors.groupingBy(ResultFlight::getYearDeparture));
        List<StatisticObject> result = new ArrayList<>();

        res.forEach((k, v) -> {
            AtomicInteger total = new AtomicInteger();
            v.forEach(item -> item.getClassTypeList().forEach(cl -> {
                total.addAndGet(cl.getPrice() * (cl.getQuantity() - cl.getRemainingQuantity()));
            }));
            result.add(new StatisticObject(k, total.get()));
        });

        return Response.ok(result);

    }

    /**
     * Statistic flight of airline by month
     * @param airlineCode
     * @return
     */
    public Response statisticFlightByMonth(String airlineCode) {

        List<ResultFlight> list = this.getAll(airlineCode);
        Map<String, List<ResultFlight>> res = list.stream().collect(Collectors.groupingBy(ResultFlight::getMonthDeparture));
        List<StatisticObject> result = new ArrayList<>();

        res.forEach((k, v) -> {
            AtomicInteger total = new AtomicInteger();
            v.forEach(item -> item.getClassTypeList().forEach(cl -> {
                total.addAndGet(cl.getPrice() * (cl.getQuantity() - cl.getRemainingQuantity()));
            }));
            result.add(new StatisticObject(k, total.get()));
        });

        return Response.ok(result);
    }

    /**
     * Statistic flight of airline by class type
     * @param airlineCode
     * @return
     */
    public Response statisticFlightByClassType(String airlineCode) {

        List<ResultFlight> list = this.getAll(airlineCode);
        Map<String, List<ResultFlight>> res = list.stream().collect(Collectors.groupingBy(ResultFlight::getYearDeparture));

        List<Map<String, String>> result = new ArrayList<>();

        res.forEach((k, v) -> {
            Map<String, String> obj = new HashMap<>();

            obj.put("year", k);
            AtomicInteger pt = new AtomicInteger();
            AtomicInteger tg = new AtomicInteger();
            AtomicInteger pt_db = new AtomicInteger();
            AtomicInteger hn = new AtomicInteger();

            v.forEach(item -> item.getClassTypeList().forEach(cl -> {
                switch (cl.getClassType()) {
                    case PHO_THONG:
                        pt.addAndGet(cl.getPrice() * (cl.getQuantity() - cl.getRemainingQuantity()));
                    case HANG_NHAT:
                        hn.addAndGet(cl.getPrice() * (cl.getQuantity() - cl.getRemainingQuantity()));
                    case THUONG_GIA:
                        tg.addAndGet(cl.getPrice() * (cl.getQuantity() - cl.getRemainingQuantity()));
                    default:
                        pt_db.addAndGet(cl.getPrice() * (cl.getQuantity() - cl.getRemainingQuantity()));
                }
            }));
            obj.put("pt", pt.toString());
            obj.put("pt_db", pt_db.toString());
            obj.put("tg", tg.toString());
            obj.put("hn", hn.toString());
            result.add(obj);
        });

        return Response.ok(result);
    }

}
