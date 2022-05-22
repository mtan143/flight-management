package com.flightmanagement.flightmanagement.forKhang;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Outside {


    String[] foods_name = {"Bún bò", "Bún thịt nướng", "Cơm sườn bì chả", "Cơm chiên dương châu", "Phở", "Bún Riêu", "Bánh cuốn", "Mì Udon xào"};

    @GetMapping("/foods_name")
    private String[] foods_name() {
        return foods_name;
    }
    String[] foods_price = {"30.000đ - 45.000đ", "25.000đ - 30.000đ", "35.000đ - 50.000đ", "30.000đ - 40.000đ", "30.000đ - 45.000đ", "25.000đ - 35.000đ", "25.000đ - 35.000đ", "35.000đ - 50.000đ"};

    @GetMapping("/foods_price")
    private String[] foods_price() {
        return foods_name;
    }
    String[] foods_material = {"300gr xương heo\n200 gr thịt đùi heo (hoặc giò heo)\n200gr thịt cua\n200gr tôm sú\n200gr nấm rơm\n50gr hành lá và ngò rí có rể\n½ kg bánh canh bột gạo\n04 củ hành khô\n½ chén bột năng\nDầu màu điều, gia vị nêm nếm gồm: nước mắm, muối, đường, tiêu, dầu ăn",

            "Thịt heo: 700gr (nên chọn loại thịt nạc vai)\nChả giò (đã chiên): 4 – 5 miếng\nBún tươi: 1kg\nHành lá: 2 nhánh\nCác loại rau: xà lách, chanh, ớt tươi, dưa leo, đồ chua, húng bạc hà, tía tô, kinh giới (định lượng tùy theo sở thích của bạn)\nĐậu phộng rang: 100gr\nGia vị: nước mắm, xì dầu, tiêu, đường, dầu ăn, hành tây và tỏi băm nhỏ, xì dầu và dầu hào",

            "10 miếng thịt cốt lết cắt lát vừa\n500 gr thịt nạc dăm\n300 gr bì\n3 tai nấm mèo\n1 lọn bún tàu\n1 củ cà rốt + 1 củ cải trắng\nHành lá, sả, tỏi, hắc xì dầu, sữa đặc, dầu hào, và gia vị\nDưa leo, cà chua & cơm trắng\n3 quả trứng\n2 trái dừa tươi",

            "4 chén cơm trắng\n2 quả trứng gà\n100g thịt xá xíu\n1 cây lạp xưởng\n20g tôm khô\n100g đậu Hà Lan\n1 củ cà rốt\n1 nắm ngò rí\n1 nắm hành lá\n1 củ tỏi\nCác gia vị cần thiết khác: dầu điều, dầu ăn, nước tương (xì dầu), hạt nêm, đường, muối, tiêu xay…",

            "2kg xương ống bò\n1,2kg bò phi lê\n0,7kg bò bắp\n1kg bánh phở\n400g hành tây\n200g sả cây\nHành tím\nGừng\nThảo mộc nấu nước dùng: quế khô, thảo quả, vỏ quýt, hoa hồi, đinh hương, hạt ngò\nRau ăn kèm: hành lá, ngò gai, ngò rí, chanh, ớt, húng quế, rau om\nGia vị nấu phở bò: muối, nước mắm, hạt nêm, đường phèn",

            "300gr xương heo\n200 gr thịt đùi heo (hoặc giò heo)\n200gr thịt cua\n200gr tôm sú\n200gr nấm rơm\n50gr hành lá và ngò rí có rể\n½ kg bánh canh bột gạo\n04 củ hành khô\n½ chén bột năng\nDầu màu điều, gia vị nêm nếm gồm: nước mắm, muối, đường, tiêu, dầu ăn",

            "1kg bún tươi\n400 gram cua đồng\n100 gram thịt xay\n50 gram tôm khô\n2 quả trứng gà\n2 bì đậu phụ\n2 quả cà chua\nHành lá, hành khô, tỏi, dấm bỗng, mắm tôm\nGia vị: muối, nước mắm,…\nRau sống ăn kèm",

            "200g bột gạo tẻ\n100g bột năng\n5 quả trứng gà\nPhần nhân bánh\n200g thịt lợn\n1 củ hành tây\n5 củ hành tím\n10g nấm mèo",

            "Mì udon tươi gói 200g\nThịt heo cắt lát 60g\nMuối\nTiêu\nBắp cải 80g\nHành tây 30g\nỚt xanh 1 trái\nBột nêm hon-dashi 1 muỗng\nXì dầu ½ muỗng\nDầu salad"
    };

    @GetMapping("/foods_material")
    private String[] foods_material() {
        return foods_material;
    }
    String[] foods_method = {"+ Bước 1: Sơ chế thực phẩm : Nấm rơm cạo sạch đất ở gốc, ngâm với nước muối pha loãng rồi rửa sạch. Với những tai nấm to bạn có thể bổ làm đôi.\nVới phần thịt cua, bạn uớp cùng ½ muỗng cà phê muối và đầu hành lá băm nhuyễn. Sau đó, phi nóng dầu màu điều rồi cho thịt cua vào xào nhanh tay và trút thịt cua ra chén riêng.\n+ Bước 2: Nấu nước lèo: Bạn xào sơ qua thịt đùi và xương heo cho săn lại. Sau đó, cho 2 lít nước lọc vào nồi nấu cùng. Nướng sơ củ hành khô cho thơm và thả vào nồi. Ngò rí rửa sạch phần rễ, đập dập rồi cùng cho vào nồi nước lèo đun để làm tăng mùi thơm. Bạn ninh tất cả trong khoảng 45 phút và nêm nếm lại cho vừa ăn là được.\nKhi thịt đùi đã chín mềm thì vớt ra trước, chần qua nước lạnh và thái miếng mỏng. Cho tôm vào nồi luộc chín và vớt ra, lột vỏ.\nThả bánh canh bột gạo và nấm rơm vào nồi nước lèo đang sôi. Đảo đều cho bánh canh chín, phần bột áo ngoài cọng bánh canh làm cho nồi nước lèo hơi sệt lại rồi nhưng nếu bạn muốn nồi nước lèo sánh hơn thì cho thêm bột năng đã pha cùng nước lạnh vào. Cuối cùng, khi thấy cọng bánh canh tự nổi lên trên là đã chín và thưởng thức được rồi đấy.\nKhi ăn, bạn vớt cọng bánh canh cho vào tô trước, sau đó xếp thịt và cua, hành ngò lên mặt. Chan nước lèo và nấm rơm vào cùng. Rắc thêm ít tiêu xay. Có thể dùng kèm với bánh giò cháo quẩy cũng rất ngon.",

            "+ Bước 1: Sơ chế nguyên liệu: Thịt lợn sau khi mua về thì sửa sạch, để ráo và thái lát mỏng cho vào tô. Ướp thịt với hành tây và tỏi băm, đường, xì dầu, nước mắm, dầu hào, mật ong và trộn đều tay cho đường tan. Sau đó để thịt ngấm gia vị trong ít nhất 1 giờ (nếu được có thể ướp thịt qua đêm).\nĐậu phộng bóc vỏ và giã hơi nhuyễn vừa ăn.\n  +Bước 2 :  Cách ướp thịt nướng ăn bún: Để món ăn thơm ngon chuẩn vị thì cách ướp thịt làm bún thịt nướng rất quan trọng. Vì vậy, khi thực hiện đến khâu này, các bạn hãy cẩn thận một tý nhé.Bạn ướp thịt như sau: cho 1 muỗng cà phê hành tây và 1 muỗng cà phê tỏi băm, ½ muỗng canh đường, 1 muỗng canh xì dầu, 1 muỗng canh nước mắm, 1 muỗng canh dầu hào, ½ muỗng canh mật ong và trộn đều.\n+ Bước 3: Nướng thịt: Bạn có thể nướng thịt bằng lò nướng hoặc lò than đều được nhưng thường thì nướng thịt với bếp than sẽ cho mùi vị thơm ngon hơn.\nNếu bạn sử dụng lò nướng thì nướng thịt với nhiệt độ 375 độ F trong từ 10 – 15 phút.\nNếu bạn nướng thịt bằng lò than thì trải thịt đều lên vỉ nướng, không để chồng chéo. Trong quá trình nướng, bạn có thể bôi lên thịt lớp dầu ăn cho càng hấp dẫn hơn.\n+ Bước 4: Pha nước mắm chua ngọt: Bạn pha nước chắm theo công thức sau: 2 muỗng canh nước mắm, 2 muỗng canh cốt chanh, 2 muỗng canh đường, 4 muỗng canh nước lọc, 2 muỗng café tỏi, ớt băm nhuyễn, khuấy đều.",

            "+ Bước 1: Thịt cốt lết rửa với nước muối loãng để ráo. Cho tỏi, sả, dầu hào, hắc xì dầu, nước mắm, đường vàng, hạt tiêu và sữa đặc vào máy xay nhuyễn và đều. Cho thêm dầu ăn vào trộn đều. Thịt dùng giấy thấm cho ráo nước rồi dùng chày dần cho thịt mềm và ướp với hỗn hợp nước vừa pha khoảng 1h hay qua đêm trong ngăn mát tủ lạnh.\n+ Bước 2: Thịt nạc dăm rửa sạch với nước muối loãng, cắt phân nửa đem xay nhuyễn. Nấm mèo ngâm nở cắt nhỏ, bún tàu ngâm nở cắt nhỏ. Tất cả cho vào tô cùng 2 quả trứng và hành tím băm nhỏ. Nêm nước mắm, hạt nêm, đường và tiêu.\n+ Bước 3: Trộn tất cả cho vừa ăn rồi đem trứng hấp chín.\n+ Bước 4: Trứng chín dùng lòng đỏ trứng phết lên mặt chả và hấp thêm 5p\n+ Bước 5: Nửa phần thịt còn lại luộc chín với nước dừa tươi và tí xíu muối, sau đó cắt sợi trộn cùng bì, thính và tỏi bằm.\n+ Bước 6: Bắt chảo cho tí xíu dầu để thắm chảo, không cho nhiều dầu. Sau đó cho thịt vào, trở đều chín 2 mặt sẽ có thịt áp chảo mềm, ngon và thơm.\n+ Bước 7: Cho nước dừa tươi, nước mắm và tí đường vào pha nước mắm cho vừa khẩu vị, cho thêm tí chanh và ớt bằm. \n+ Bước 8: Khi ăn cơm thì múc chén cơm úp ngược lên dĩa, miếng sườn, bì, chả, dưa leo, cà chua và ít đồ chua ăn kèm nước mắm.",

            "+ Bước 1:Đầu tiên, bạn thái nhỏ lần lượt thịt xá xíu, lạp xưởng thành hạt lựu. Sau đó, bạn luộc sơ đậu Hà Lan, cà rốt (đã được rửa sạch với nước muối pha loãng). Tiếp đó, bạn thái cà rốt thành hạt lựu chuẩn bị thực hiện món ăn này.\n+ Bước 2:Trong thời gian đó, bạn ngâm tôm khô với nước để tôm nở mềm. Sau đó, bạn bắc chảo lên bếp, khi chảo nóng, bạn cho lạp xưởng vào chiên sơ qua. Lưu ý, bạn không nên dùng dầu ăn trong công đoạn này, bởi vì trong lạp xưởng có sẵn mỡ. Tiếp đó, bạn đập trứng gà vào trong bát nhỏ, dùng đũa đánh cho trứng bông đều.\n+ Bước 3: Ướp gia vị : Sau đó, bạn cho cơm, thịt xá xíu vào chung một bát lớn. Lúc này, bạn cho gia vị vào theo công thức: 1/3 muỗng cà phê muối, 1 muỗng cà phê đường, 2 muỗng cà phê hạt nêm, 1 muỗng cà phê dầu điều và dùng đũa trộn đều. Đây là công đoạn quan trọng trong cách làm cơm chiên Dương Châu ngon ảnh hưởng trực tiếp đến hương vị thành phẩm thu được.\n+ Bước 4: Tiếp đó, bạn bắc một chảo khác lên bếp có sẵn 2 muỗng canh dầu ăn. Khi dầu nóng, bạn cho trứng đã được đánh đều vào chảo chiên. Khi trứng hơi chín tới, bạn cho hỗn hợp cơm vào trộn đều. Theo hướng dẫn chiên cơm của nhiều chuyên gia ẩm thực, bạn nên dùng đũa đảo đều để cơm tơi và không bị khô.\n+ Bước 5: Cuối cùng, bạn cho cơm chiên ra đĩa và rắc thêm ít tiêu xay, hành lá và rau ngò thái nhỏ lên trên để trang trí món ăn thêm bắt mắt.",

            "+ Bước 1: Sơ Chế Nguyên Liệu : Hành tây bóc vỏ, 1 phần thái lát mỏng, 1 phần thái múi cau\nNgò rí rửa sạch, thái nhỏ.\nHành lá để riêng phần đầu hành, phần lá thái nhỏ\nCác loại rau ăn kèm rửa sạch, để ráo.\n+ Bước 2: Cách nấu nước dùng phở bò : Xương ống bò rửa sạch. Bắc nồi nước lên bếp cùng với một ít sả cây đun sôi. Cho xương vào chần sơ qua để khử đi mùi hôi. Vớt xương đã chần ra, cho vào khay cùng với gừng, hành tím, hành tây cắt múi cau đem đi nướng đến khi xương vàng, lấy xương ra khỏi lò, cho ngay vào thau nước đá.Đun sôi một nồi nước, cho xương bò đã nướng, gói gia vị vừa làm, hành tây, gừng đã nướng, sả vào nồi nước. Hầm xương khoảng 5 – 6 tiếng cho ra nước ngọt. Trong lúc hầm xương, bạn cho thịt bắp bò vào luộc chín. Lưu ý là luộc thịt bắp bò chín thì vớt ra ngay nếu để quá lâu thịt sẽ bị mềm nhũn. Sau đó vớt các nguyên liệu ra, lọc lấy nước dùng.Bắc nồi nước dùng đã lọc lên bếp, nêm một ít muối, bột ngọt, hạt nêm, đường phèn sao cho vừa ăn, đun sôi và tắt bếp.",

            "+ Bước 1: Sơ chế thực phẩm : Nấm rơm cạo sạch đất ở gốc, ngâm với nước muối pha loãng rồi rửa sạch. Với những tai nấm to bạn có thể bổ làm đôi.\nVới phần thịt cua, bạn uớp cùng ½ muỗng cà phê muối và đầu hành lá băm nhuyễn. Sau đó, phi nóng dầu màu điều rồi cho thịt cua vào xào nhanh tay và trút thịt cua ra chén riêng.\n+ Bước 2: Nấu nước lèo :Bạn xào sơ qua thịt đùi và xương heo cho săn lại. Sau đó, cho 2 lít nước lọc vào nồi nấu cùng. Nướng sơ củ hành khô cho thơm và thả vào nồi. Ngò rí rửa sạch phần rễ, đập dập rồi cùng cho vào nồi nước lèo đun để làm tăng mùi thơm. Bạn ninh tất cả trong khoảng 45 phút và nêm nếm lại cho vừa ăn là được.\nKhi thịt đùi đã chín mềm thì vớt ra trước, chần qua nước lạnh và thái miếng mỏng. Cho tôm vào nồi luộc chín và vớt ra, lột vỏ.\nThả bánh canh bột gạo và nấm rơm vào nồi nước lèo đang sôi. Đảo đều cho bánh canh chín, phần bột áo ngoài cọng bánh canh làm cho nồi nước lèo hơi sệt lại rồi nhưng nếu bạn muốn nồi nước lèo sánh hơn thì cho thêm bột năng đã pha cùng nước lạnh vào. Cuối cùng, khi thấy cọng bánh canh tự nổi lên trên là đã chín và thưởng thức được rồi đấy.\nKhi ăn, bạn vớt cọng bánh canh cho vào tô trước, sau đó xếp thịt và cua, hành ngò lên mặt. Chan nước lèo và nấm rơm vào cùng. Rắc thêm ít tiêu xay. Có thể dùng kèm với bánh giò cháo quẩy cũng rất ngon.",

            "+ Bước 1: Đậu phụ sau khi mua về bạn mang rửa sạch, để ráo nước rồi thái thành những miếng vừa ăn. Sau đó, đem chiên chín vàng.\n+ Bước 2: Cà chua rửa sạch, thái múi cau rồi đem xào qua với dầu ăn trong 1 – 2 phút.\n+ Bước 3: Cua đồng rửa sạch, bóc bỏ mai yếm rồi dùng đũa hoặc que nhỏ để lấy phần nước màu ở mai cua.\n+ Bước 4: Phần thân cua cho vào máy xay sinh tố xay nhuyễn cùng chút muối.\n+ Bước 5: Trút xác cua vào một bát lớn, đổ thêm khoảng 200ml nước lọc vào và dùng tay bóp nhẹ phần thịt cua. Gạn đổ nước lẫn thịt cua vào nồi từ 2 – 3 lần, đến khi trong bát chỉ còn phần vỏ cứng.\n+ Bước 6: Cho một ít muối, hạt nêm vào nồi nước cua vừa lọc. Sau đó, đặt lên bếp đun nóng với mức lửa vừa. Vừa đun, bạn vừa dùng đũa khuấy nhẹ tay để riêu cua kết lại và nổi lên hết trên mặt nước.\n+ Bước 7: Dùng muôi vớt hết phần riêu cua nổi ra một bát riêng. Sau đó, đổ phần cà chua đã được xào sơ qua ở bước 2 vào nồi.\n+ Bước 8: Cho 1 thìa mắm tôm và nêm nếm thêm các loại gia vị khác cho nồi nước dùng vừa ăn rồi đậy kín nắp vung và tiếp tục đun với mức lửa nhỏ.\n+ Bước 9: Đặt một chảo dầu lên bếp đun sôi rồi cho hành khô vào phi thơm. Sau đó, cho phần nước màu ở mai cua vào đảo đều rồi tắt bếp. Phần nước này bạn có thể cho luôn vào nồi nước dùng hoặc cũng có thể cho vào từng bát khi ăn.",

            "+ Bước 1: Pha bột làm bánh : Trứng gà đem đập vào bát, dùng máy đánh trứng đánh đều rồi lọc qua rây lọc.\nCho bột năng và bột gạo vào bát tô, từ từ đổ nước vào hỗn hợp, khuấy đều.\nĐể hỗn hợp bột lắng trong khoảng 1 giờ, đánh dấu mức nước rồi gạn phần nước trong đổ đi.\n+ Bước 2: Sơ chế nguyên liệu phần nhân bánh : Nấm mèo đem ngâm với nước ấm khoảng 15 phút cho nở, rửa sạch, băm nhỏ.\nHành tím và hành tây bóc vỏ, rửa sạch, băm nhỏ.\nThịt lợn rửa sạch, cho vào máy xay thịt xay nhỏ rồi đem trộn đều với 1 thìa canh hạt nêm. Tiếp theo, bạn dùng màng bọc thực phẩm bọc miệng bát lại, ướp trong khoảng 10 phút cho ngấm đều gia vị.\n+ Bước 3: Xào nhân : Đặt chảo lên bếp, vặn nhỏ lửa, thêm 1 thìa canh dầu ăn vào đun sôi.\nĐổ phần thịt xay, nấm mèo, hành tây, hành tím vào chảo, đảo đều, xào chín.\n+ Bước 4: Trình bày và thưởng thức : Sau khi đã hoàn thành xong các bước làm bánh cuốn trứng trên đây, bạn lấy ra đĩa, cắt thành miếng vừa ăn, trang trí sao cho đẹp mắt rồi thưởng thức thành quả của mình."


    };
    @GetMapping("/foods_method")
    private String[] foods_method() {
        return foods_method;
    }
    String[] foods_location = {
            "21 Phạm Vấn, Phú Thọ Hoà, Tân Phú, Thành phố Hồ Chí Minh",

            "165 Lê Thiệt, Phú Thọ Hoà, Tân Phú, Thành phố Hồ Chí Minh\n116 Miếu Gò Xoài, Bình Hưng Hoà A, Bình Tân, Thành phố Hồ Chí Minh",

            "165 Lê Thiệt, Phú Thọ Hoà, Tân Phú, Thành phố Hồ Chí Minh\n116 Miếu Gò Xoài, Bình Hưng Hoà A, Bình Tân, Thành phố Hồ Chí Minh",

            "18/1 Nguyễn Cảnh Chân, P. Cầu Kho, Quận 1",

            "222 Thạch Lam, Phú Thạnh, Tân Phú, Thành phố Hồ Chí Minh\n25 Lương Trúc Đàm, Hoà Thanh, Tân Phú, Thành phố Hồ Chí Minh",

            "313 Lê Văn Quới, Bình Trị Đông A, Bình Tân, Thành phố Hồ Chí Minh",

            "29, Huỳnh Thiện Lộc, Phường Hòa Thạnh, Quận Tân Phú, Thành Phố Hồ Chí Minh",

            "215 - 217 Lý Tự Trọng, P. Bến Thành, Quận 1, Hồ Chí Minh\nLầu 1, Aeon Mall Celadon Tân Phú, Quận Tân Phú, Hồ Chí Minh"

    };
    @GetMapping("/foods_location")
    private String[] foods_location() {
        return foods_location;
    }
    String[] organic_name = {"Hủ Tiếu Chay", "Canh Nấm Hạt Sen", "Đậu Hủ Xào Rau Củ", "Canh Rong Biển Hạt Sen", "Nem Rán Chay"};

    @GetMapping("/organic_name")
    private String[] organic_name() {
        return organic_name;
    }
    String[] organic_price = {"30.000đ - 45.000đ", "30.000đ - 50.000đ", "30.000đ - 45.000đ", "80.000đ - 100.000đ", "30.000đ - 45.000đ"};

    @GetMapping("/organic_price")
    private String[] organic_price() {
        return organic_price;
    }
    String[] organic_material = {
            "Hủ tiếu: 70 Gram\nCải thảo: 4 Lá\nCà rốt: 1/4 Củ\nCủ cải trắng: 1 Củ vừa\nNấm đông cô (Tươi): 15 Gram\nTàu hũ ky: 5 Gram\nĐậu hũ chiên: 2 Miếng\nChả lụa chay: 20 Gram\nHẹ: 5 Gram\nNgò rí: 1 Nhánh\nHành boa rô: 1 cây\nGiá đỗ: 20 Gram\nXà lách: 1 Bắp vừa\nMuối: 3/4 Muỗng cà phê\nĐường trắng: 1/2 Muỗng cà phê\nBột ngọt: 1/2 Muỗng cà phê\nĐường phèn: 5 Gr\nNước tương: 1 Muỗng cà phê\nHạt nêm chay: 1/2 Muỗng cà phê\nChanh, ớt (tùy ý thích)",

            "Hạt sen: 50g\nNấm đông cô tươi : 50g\nNấm linh chi : 50g\nCà rốt : 1/2 cây\nĐậu hũ non : 100g\nNgò rí\nTiêu\nHạt nêm",

            "Đậu hũ 1 miếng\nỚt chuông xanh/ vàng/ đỏ 1/2 trái\nNấm đông cô tươi 3 cây (có thể dùng khô)\n Hành tây 1 củ\n Mè rang 1 muỗng cà phê\n Nước tương 4 muỗng cà phê\n Dầu mè 1 muỗng canh\n Dầu ăn 2 muỗng canh \n Đường ngô 4 muỗng canh (có thể thay bằng đường trắng)\n Muối 1 muỗng cà phê",

            "Rong biển khô: 100g\nHạt sen khô hoặc tươi đều được. Nếu được, hãy dùng hạt sen tươi để rút ngắn thời gian nấu\nCà rốt: 1 củ nhỏ\nNấm rơm: 100g\nGừng: 1 nhánh nhỏ: có tác dụng át chế mùi tanh của rong biển\nGia vị: hạt nêm chay, tiêu xay, muối",

            "Bánh đa nem: 1 gói\nMiến: 50-100 g\nCà rốt, hành tây mỗi thứ ½ củ\nNấm hương, mộc nhĩ: 4-5 tai (ngâm nở, rửa sạch)\nGiá đỗ: 100 g\nHành hoa, rau mùi (ngò)\nDầu ăn, bột canh, mì chính, hạt tiêu"
    };

    @GetMapping("/organic_material")
    private String[] organic_material() {
        return organic_material;
    }
    String[] organic_method = {

            "+ Bước 1: Nấu nước dùng hủ tiếu :  Bắc chảo lên bếp, cho gốc hành boa rô băm nhỏ vào khử cho thơm, sau đó cho nấm đông cô vào chảo, cho nước tương vào xào đều khoảng 2-3 phút rồi nhắc xuống.\nCho một lượng nước vừa đủ khẩu phần vào một nồi, đun tới sôi thì cho cà rốt và củ cải trắng vào nấu cho ra nước ngọt, đến khi mềm thì rút nấm đã xào vào.\nTiếp tục nấu sôi thì cho hết phần cải thảo còn lại vào, giảm lửa để cải thảo không bị mềm bấy. Nêm nếm gia vị: muối, bột ngọt, đường, hạt nêm chay cho vừa ăn.\n+ Bước 2: Hoàn thành : Trụng hủ tiếu sơ qua với nước sôi để khi chế nước dùng nóng vào không bị bấy.\nSắp chả chay và rắc ngò rí với hẹ lên trên. Múc đầy đủ cà rốt, cải thảo, nấm, tàu hũ lên rồi chan nước dùng vào.",

            "+ Bước 1: Sơ chế : Cà rốt tỉa hoa, cắt lát. Nấm các loại sơ chế sạch, để ráo. Ngò rí cắt nhỏ.\nĐậu hũ non cắt miếng vừa ăn.\n+ Bước 2: Thực hiện : Đun sôi 1 lít nước, cho hạt sen và cà rốt vào nấu khoảng 10 phút, tiếp tục cho các loại nấm vào nấu chín, nêm 3M hạt nêm Aji-ngon từ nấm hương và hạt sen, cho đậu hũ vào tắt bếp, rắc thêm tiêu và ngò rí.",

            "+ Bước 1: Sơ chế nguyên liệu : Ngâm nấm đông cô trong nước ấm khoảng 1 - 2 phút để sạch hết đất và bụi bẩn bám trên thân nấm. Sau đó vớt ra và rửa sạch dưới vòi nước.\nNấm đông cô cắt bỏ chân nấm rồi cắt thành những lát mỏng vừa ăn.\n+ Bước 2: Sơ chế và chiên đậu hũ : Đậu hũ mua về rửa sơ qua nước rồi để thật ráo, sau đó cắt thành những lát dày khoảng 1/2 đốt ngón tay.\nBắc chảo lên bếp và cho vào 2 muỗng canh dầu ăn, đun nóng. Khi dầu nóng, cho đậu hũ vào chiên trong 5 - 7 phút ở lửa vừa cho đến khi đậu hũ được vàng giòn thì vớt ra cho ráo dầu.\nĐậu hũ sau khi chiên, bạn cắt thành sợi dài tương đương phần rau củ.\n+ Bước 3: Xào đậu hũ với rau củ : Trên cùng chảo dầu chiên đậu, bạn đun nóng chảo rồi cho các loại rau và nấm vào xào trong 3 - 5 phút ở lửa lớn, nêm thêm 1 muỗng cà phê muối vào và đảo đều cho đến khi hành tây bắt đầu đổi màu trong và ớt chuông mềm. Sau đó, bạn cho phần đậu hũ vào và đảo đều.\nCho vào 4 muỗng cà phê nước tương và 4 muỗng cà phê đường ngô, đảo đều. Xào khoảng 2 - 3 phút để tất cả nguyên liệu thấm đều gia vị rồi tắt bếp. Cho vào 1 muỗng canh dầu mè và 1 muỗng cà phê mè rang vào, đảo qua rồi qua thấm đều gia vị rồi nêm nếm lại cho vừa ăn, bày ra đĩa.\n+ Bước 4: hành phẩm : Đậu hũ xào rau củ có màu sắc đẹp mắt, vừa chín tới lại thấm vị, cực kì thơm ngon mà lại không hề bị nhiều dầu mỡ, thích hợp để ăn vào những ngày nóng bức hoặc khi bạn cảm thấy ngán các món thịt cá.\nMón ăn được ăn kèm với cơm nóng là ngon hết ý luôn!",

            "+ Bước 1: Sơ chế nguyên liệu : Cho rong biển khô vào nước ngâm cho nở rồi đem vớt ra để ráo nước.\nCà rốt đem gọt vỏ, rửa sạch, tỉa hoa và thái miếng mỏng vừa.\nGừng cạo vỏ, đem đập rập.\nNấm rơm rửa sạch với nước ấm, cắt thành miếng nhỏ vừa ăn.\nHạt sen tươi đem bóc bỏ vỏ, bỏ phần tâm sen đi, rửa sạch lại rồi để ráo nước.\n+ Bước 2: Cho khoảng 500ml nước lạnh vào nồi, sau đó cho hạt sen cùng gừng đã dập vào đun. Đun trong khoảng 8 phút để hạt sen mềm hơn, sau đó mới tiếp tục cho cà rốt, nấm rơm vào nấu cùng. Nêm các loại gia vị.\n+ Bước 3: Đợi đến khi bạn thấy hạt sen đã chín mềm, cà rốt cũng chín tới thì mới bắt đầu cho rong biển vào. Đun sôi lại rồi tắt bếp là xong rồi. Rong biển không nên nấu quá lâu sẽ bị nhừ quá, ăn không ngon.",

            "Các nguyên liệu rửa sạch, hành tây thái mỏng, cà rốt, mộc nhĩ, nấm hương thái sợi nhỏ, hành hoa, rau mùi (ngò) thái nhỏ.\nCho các nguyên liệu trên vào bát to, cho miến  (ngâm nước ấm, cắt nhỏ) thêm chút xíu bột canh, mì chính, hạt tiêu (hạt tiêu tùy theo khẩu vị ăn) và trộn đều.\nChải bánh đa nem, cho nhân vừa đủ, cuộn tròn bánh đa nem, làm cho đến khi hết nhân nem\nĐun sôi dầu trong chảo, thả nem vào và rán vàng hai mặt.\nGắp ra đĩa và chấm với nước mắm chua cay mặn ngọt. "
    };

    @GetMapping("/organic_method")
    private String[] organic_method() {
        return organic_method;
    }
    String[] organic_location = {
            "24 Lò Siêu, Phường 16, Quận 11, Thành phố Hồ Chí Minh\n24 Phú Thọ, Phường 2, Quận 11, Thành phố Hồ Chí Minh",

            "12 Lê Lăng, Phú Thọ Hoà, Tân Phú, Thành phố Hồ Chí Minh\nAn D. Vương, Bình Trị Đông, Bình Tân, Thành phố Hồ Chí Minh",

            "188 Đường Hàn Hải Nguyên, Phường 8, Quận 11, Thành phố Hồ Chí Minh\n54A Trương Phước Phan, Bình Trị Đông, Bình Tân, Thành phố Hồ Chí Minh",

            "142 Trần Quý, Phường 6, Quận 11, Thành phố Hồ Chí Minh\n280 Lãnh Binh Thăng, Phường 8, Quận 11, Thành phố Hồ Chí Minh",

            "86 Đường Hàn Hải Nguyên, Phường 2, Quận 11, Thành phố Hồ Chí Minh"
    };

    @GetMapping("/organic_location")
    private String[] organic_location() {
        return organic_location;
    }
    String[] ff_name = {"Mì Spaghetti", "Pizza", "Bánh Mì Kẹp", "Bánh Mì Cuộn", "Hamburger", "Bít Tết Phô Mai"};

    @GetMapping("/ff_name")
    private String[] ff_name() {
        return ff_name;
    }
    String[] ff_price = {"50.000đ - 70.000đ", "50.000đ - 70.000đ", "15.000đ - 30.000đ", "15.000đ - 30.000đ", "15.000đ - 30.000đ", "40.000đ - 60.000đ"};

    @GetMapping("/ff_price")
    private String[] ff_price() {
        return ff_price;
    }
    String[] ff_material = {"Khoảng 450 gr thịt bò xay\n1 củ hành tây cắt nhỏ\n2 thìa cà phê muối\n3 thìa cà phê hạt tiêu\n2 nhánh tỏi băm\n30 gram sốt cà chua đặc (nguyên chất)\n425 gram sốt cà chua (ketchup)\nKhoảng 800 gram cà chua tươi cắt nhỏ\n4 thìa cà phê cỏ xạ hương khô\n2 thìa cà phê húng quế khô\n2 thìa cà phê cỏ hương thảo khô\n1 thìa cà phê kinh giới tây khô\n1 thìa cà phê lá thơm (bay leaf) nghiền",

            "100gr bột mì\n5gr men nở\n150ml nước\n1 thìa dầu olive\nPhô mai ( nên chọn các loại phomai có thương hiệu tại châu Âu nhé)\nSốt cà chua. Bạn có thể tự mua bên ngoài hoặc cũng có thể tự chế biến cho theo sở thích nhé.\nNhân pizza",

            "Bánh mì: 4 ổ\nThịt heo: 300 gram\nRau răm: 1 mớ\nRượu trắng: 30m\nNước lọc: 50ml\nỚt: 2 quả\nTỏi: 1 củ\nDưa leo: 1 quả",

            "250g bột mì số 13\n1 quả trứng\n100ml sữa tươi không đường\n2g muối\n3g men nở\n50g đường\n30g bơ",

            "Hành tây, hành khô, tỏi\nBột năng, muối và gia vị\nTrứng\nBột chiên xù\nRau xà lách\nRau mùi thơm\nDưa chuột\nBánh mì tròn",

            "Thịt thăn lưng bò 500 gr\n Nấm mỡ trắng 100 gr (hoặc nẫm mỡ nâu)\n Phô mai lát 4 lát\n Bơ lạt 200 gr\n Sữa tươi không đường 150 ml\n Rau xà lách caron 2 bó\n Cà chua bi 200 gr\n Hạt bắp Mỹ 100 gr (khoảng 7 muỗng canh)\n Hành tây 1 củ\n Tỏi 6 tép\n Sốt teriyaki 2 muỗng canh\n Sốt mè rang 3 muỗng canh\n Dầu hào 1/2 muỗng canh\n Bột năng 2 muỗng cà phê\n Dầu oliu 200 ml\n Nước cốt chanh 2 muỗng canh\n Mật ong 1 muỗng canh\n Bột ớt 1 muỗng cà phê\n Muối/tiêu 1 ít"

    };

    @GetMapping("/ff_material")
    private String[] ff_material() {
        return ff_material;
    }
    String[] ff_method = {
            "Cho thịt bò xay và chảo chống dính, rộng và sâu, để lửa vừa và đảo tới khi thịt chuyển sang màu nâu (loại bỏ mỡ nếu có).\nCho tiếp hành vào đảo tới khi hành chín mềm, nêm gia vị muối, tiêu.\nTrộn tỏi vào hỗn hợp 3 loại cà chua với nhau, sau đó, đổ tất vào chảo thịt.\nCho tiếp các loại thảo mộc vào cùng. Đậy lại và đun liu riu ở lửa nhỏ khoảng 30 phút là được.",

            "Đầu tiên, bạn nướng rau củ gồm cà tím và bí ngô ở nhiệt độ 230ºC trong thời gian 15 phút. Trong quá trình nướng, bạn cần lật qua miếng rau củ để nguyên liệu không bị khô. Sau đó, bạn sơ chế qua hành tây, ớt chuông bằng cách xào trên bếp từ 4 đến 5 phút. Cuối cùng, bạn xếp nhân lên bánh pizza theo thứ tự: Phô mai, cà tím, bí ngô, hành tây và ớt chuông rồi bỏ bánh vào lò, nướng trong 20 phút ở nhiệt độ 230ºC.\nVới pizza chay nấm bông cải, bạn phết một lớp sốt cà chua lên bánh rồi đặt topping theo thứ tự: Ớt chuông, bông cải, nấm đùi gà, hành tây, cà chua và phô mai bào sợi. Sau đó, bạn nướng bánh ở nhiệt độ 200ºC trong 15 đến 20 phút để bánh chín.",

            "+ Bước 1: Sơ chế nguyên liệu :Rửa sạch thịt heo với nước muối loãng, để ráo nước. Tiếp theo, khứa vài đường lên trên miếng thịt rồi dùng xiên đâm nhẹ lên phần bì để gia vị thấm đều vào thịt.\nBóc vỏ tỏi, rửa tỏi với ớt cho sạch, băm nhỏ.\nNgắt phần non của rau răm, cũng rửa sạch và để ráo nước.\nCắt hai đầu của dưa leo để nhựa chảy ra, ngâm một lúc trong nước muối loãng. Sau đó cắt dưa thành các lát mỏng.\n+ Bước 2: Cách ướp thịt heo quay : Trộn đều muối, ngũ vị hương, 1 thìa đường, giấm, tiêu xay và rượu trắng trong bát để các nguyên liệu hòa quyện vào nhau.\nDùng cọ phết hỗn hợp gia vị lên thịt, dùng  tay bóp nhẹ miếng thịt.\nLau sạch gia vị trên phần bì, để yên thịt khoảng 4 tiếng.\nCách làm nước xốt bánh mì thịt heo quay\nCho ớt băm, tỏi băm, nước lọc, nước mắm cùng 1 thìa cà phê đường vào bát, khuấy đều đến khi đường tan hết là xong phần nước xốt của bánh mì thịt heo quay.\n+ Bước 3: Hoàn thành và hưởng thức : Nếu bánh mì bị mềm, hãy cho vào lò vi sóng hoặc chảo để quay nóng. Sau đó, xẻ dọc ổ bánh, lần lượt cho thịt heo quay, rau rắm, dưa leo và rưới nước xốt lên trên là xong.\nBánh mì thịt heo quay ngon nhất là khi mới được làm xong, bạn có thể thưởng thức bánh vào bất cứ lúc nào khi mình đói. Nếu muốn tăng hương vị, hãy thêm một chút đồ chua (củ cải, cà rốt, đu đủ) và tương ớt cay cay.",

            "Để làm bánh, các bạn sẽ trộn đều các nguyên liệu bằng tay với các động tác gập bột và đập bột một cách cơ bản nhất.\nNếu thời tiết nóng bức, bạn sẽ chỉ cần mất 20 phút để bột nở đạt. Hãy canh giờ và quan sát bột nếu bạn không muốn bánh mì của bạn chỉ toàn mùi chua của men.\nBột sau khi nở đạt sẽ ấn xẹp bột, nhồi sơ lại từ 5-10 phút. Tùy vào các loại khuôn mà các bạn sẽ chia thành các phần bằng nhau. Hiện nay, bánh mì cuộn len được nhiều bạn trẻ biết đến với những hình tròn được ghép từ 4 miếng bột, giống như 4 cuộn len được chắp lại.\nMỗi một miếng bột các bạn sẽ cán thành hình chữ nhật dài, một đầu sẽ sử dụng dao sắc hoặc dụng cụ rạch bánh chuyên nghiệp rạch thật nhiều đường.\nCuộn lại từ phần bột chưa cắt, mép bột được nên được chỉnh lại để khi bánh nở sẽ không bị mất thớ. Các bạn xếp đều 4 phần bột và khuôn tròn đã được chống dính.\nCác bạn sẽ để bánh nở đến khi gấp đôi thì bật lò 180 độ C nướng 20 phút. Trước khi nướng, các bạn nên quét một lớp lòng đỏ trứng mỏng lên bề mặt bánh để bánh mì cuộn len có màu nâu vàng bắt mắt hơn. ",

            "+ Bước 1; Cho thịt bò, bột chiên xù, trứng gà vào bát to, trộn đều. Thêm 1 thìa nước mắm, 2 thìa đường vào trộn tiếp, ướp trong 30 phút cho hỗn hợp thịt, trứng, bột ngấm đều gia vị.\n+ Bước 2: Hành tây bóc vỏ, rửa sạch, thái miếng nhỏ vừa. Cà chua rửa sạch, thái khoanh nhỏ vừa ăn. Xà lách bỏ cuống, rửa sạch, tách từng lá một.\nĐun nóng dầu ăn, cho hành tây vào xào tái rồi đổ ra để ráo dầu. Hành tây sau khi xào sẽ bớt cay nồng, dễ ăn hơn.\nNặn hỗn hợp thịt bò thành bốn phần tròn, dẹt, có đường kính bằng với đường kính bánh mì đã chuẩn bị. Cho thịt bò vào chảo dầu nóng, chiên lửa nhỏ cho tới khi thịt chín, bên ngoài xém vàng là được.\n+ Bước 3: Cắt đôi bánh mì theo chiều ngang, đặt lá xà lách rồi đến một lát cà chua, hành tây, phô mai lên trên một nửa chiếc bánh. Đặt nhân thịt bò vào giữa, xếp các loại rau, phô mai như lúc nãy lên trên miếng thịt bò, cuối cùng đặt nửa bánh mì còn lại lên.\nTiếp tục làm như vậy với phần nguyên liệu còn lại.",

            "+ Bước 1: Sơ chế và ướp thịt bò :Thịt thăn bò mua về, bạn đem rửa sạch với nước muối pha loãng rồi rửa lại với nước sạch.\nCà chua bỏ cuống rồi đem rửa sạch và ngâm trong nước muối khoảng 10 phút, sau đó rửa lại với nước sạch rồi để ráo.\nHạt bắp Mỹ đem luộc chín.\nNấm mỡ rửa sơ, ngâm 10 phút với nước muối loãng rồi cắt bỏ chân nấm, sau đó rửa lại với nước sạch 2 - 3 lần rồi cắt thành những lát mỏng.\nTỏi bóc vỏ, để nguyên tép.\nHành tây lột vỏ, 1 nửa cắt lát mỏng, nửa còn lại cắt làm đôi.\n+ Bước 2: Làm sốt nấm teriyaki : Bắc chảo lên bếp và cho vào chảo 10ml dầu oliu (khoảng gần 1 muỗng canh), đợi dầu nóng thì cho nấm mỡ vào xào với lửa lớn.\n+ Bước 3: Làm sốt phô mai : Bắc 1 cái chảo khác lên bếp và cho 100gr bơ lạt vào đun chảy, sau đó cho thêm 100ml sữa tươi không đường vào chảo.\nĐun hỗn hợp liu riu ở lửa nhỏ đến khi sữa bắt đầu sôi lăn tăn thì bạn thêm 4 miếng phô mai lát vào rồi khuấy đều cho phô mai chảy hết, quyện vào sữa.\n+ Bước 4: Áp chảo thịt bò : Trước tiên, bạn đun nóng chảo với 150ml dầu oliu, sau đó cho 50gr bơ lạt vào đun chảy.\nTiếp đến, cho 3 muỗng canh sốt mè rang vào rồi trộn đều sốt với rau và quả, sau đó cho phần sốt mật ong đã pha vào rồi tiếp tục trộn thật đều tay.\n+ Bước 5: Hoàn thành : Cho miếng thịt bò áp chảo ra dĩa, rưới một nửa sốt nấm, một nửa sốt phô mai rồi gắp vào dĩa thêm 1 ít salad nữa là món ăn đã hoàn thành và chỉ đợi bạn thưởng thức! "
    };

    @GetMapping("/ff_method")
    private String[] ff_method() {
        return ff_method;
    }
    String[] ff_location = {
            "15/40C, Cầu Xéo, Phường Tân Quý, Quận Tân Phú, Thành Phố Hồ Chí Minh",

            "576 Đường 3/2, Phường 14, Quận 10, Thành phố Hồ Chí Minh",

            "12 Đường Số 12, Bình Hưng Hoà, Bình Tân, Thành phố Hồ Chí Minh",

            "14 Trần Bình Trọng, Phường 4, Quận 5, Thành phố Hồ Chí Minh",

            "137/12 Nguyễn Quý Anh, Tân Sơn Nhì, Tân Phú, Thành phố Hồ Chí Minh",

            "137/12 Nguyễn Quý Anh, Tân Sơn Nhì, Tân Phú, Thành phố Hồ Chí Minh"
    };

    @GetMapping("/ff_location")
    private String[] ff_location() {
        return ff_location;
    }


    double[] ffX = {
            10.79839505778613,
            10.767540243530568,
            10.7963299293415,
            10.763943620977555,
            10.805407933155374,
            10.805407933155374,
    };
    @GetMapping("/ffX")
    private double[] ffX() {
        return ffX;
    }


    double[] ffY = {
            106.62370950241633,
            106.66146468792624,
            106.60783157390445,
            106.67831177437725,106.62758532464427,106.62758532464427
    };

    @GetMapping("/ffY")
    private double[] locateY() {
        return ffY;
    }

//
    double[] fX = {
        10.784847469842854,
        10.786126776463792,
        10.786126776463792,
        10.75767559241183,
        10.77868436048371,
        10.776287277512706,
        10.781151155493006,
        10.77287136300719
    };

    @GetMapping("/fX")
    private double[] fX() {
        return fX;
    }

    double[] fY = {
            106.62449767759105,
            106.61891041843487,
            106.61891041843487,
            106.68941574393087,
            106.62627126750122,
            106.61076655907239,
            106.6378099166105,
            106.6955986002856
    };

    @GetMapping("/fY")
    private double[] fY() {
        return fY;
    }

    double[] organicX = {
            10.75555253666536,
            10.784470656741808,
            10.758763783409792,
            10.759283491280144,
            10.758386088576215
    };

    @GetMapping("/organicX")
    private double[] organicX() {
        return organicX;
    }

    double[] organicY = {
            106.648260851844,
            106.62378818732415,
            106.64633385613894,
            106.65477552838261,
            106.64861118756251
    };

    @GetMapping("/organicY")
    private double[] organicY() {
        return organicY;
    }


    double[] dX = {
            10.77181068283618,
            10.804079132206251,
            10.798739889883686,
            10.79521743091575,
            10.802013453600306,
            10.778246438462046,
            10.781898808272805,
            10.751656391882234,
            10.787456012459872,
            10.773566396503098
    };

    @GetMapping("/dX")
    private double[] dX() {
        return dX;
    }

    double[] dY = {
            106.63631604276391,
            106.64074872373696,
            106.68069507187646,
            106.63756029866957,
            106.6548654150518,
            106.62771591636611,
            106.65508432885548,
            106.61207577421149,
            106.63372091652474,
            106.62440147345833
    };

    @GetMapping("/dY")
    private double[] dY() {
        return dY;
    }





    String[] drinks_name = {"Cà Phê Cappuccino Đá Xay", " Cà phê Caramel Đá Xay ", "Cà phê đen", "Cà phê sữa", "Hồng trà chanh","Phin Bọt Biển", "Sinh Tố Chanh", "Sữa Chua Phúc Bồn Tử", "Trà Hoa Hồng", "Trà Nhãn Vải"};

    @GetMapping("/drinks_name")
    private String[] drinks_name() {
        return drinks_name;
    }
    String[] drinks_price = {"40.000đ - 60.000đ", "40.000đ - 60.000đ", "15.000đ - 30.000đ", "20.000đ - 35.000đ", "30.000đ - 40.000đ", "30.000đ - 45.000đ", "30.000đ - 50.000đ", "50.000đ - 68.000đ", "35.000đ - 50.000đ", "35.000đ - 50.000đ"};

    @GetMapping("/drinks_price")
    private String[] drinks_price() {
        return drinks_price;
    }
    String[] drinks_material = {"60ml Cà phê \n50ml Sữa đặc\n20gr Bột sữa\n20gr Bột Frappe\n300gr đá viên",
            "Bột cà phê 1.5 muỗng canh (25gr) Siro caramel 20ml\nTopping cream 30gr\nSữa tươi không đường 50 ml\nWhipping cream 1 ít\nNước đá đông lạnh 1 ít 150 gr",
            "Cafe bột 3 thìa canh\nĐường cát trắng 1 thìa canh\nNước sôi 100°C 160 ml",
            "Cà phê nguyên chất 25g (2-3 thìa)\nSữa đặc: 2-3 muỗng cafe (1 sữa : 1 cà phê)\nNước sôi: 100ml\nnhiệt độ 93-95 độ C",
            "5g hồng trà (dùng trà cánh hoặc thay bằng 2 túi lọc)\n1 quả chanh ta (½ dùng lấy nước, ½ dùng trang trí)\n30g đường kính (khoảng 3 thìa đường - có thể thay bằng 30ml mật ong)\n200ml nước nóng, 100g đá viên\n2 nhánh bạc hà (tùy chọn))",
            "3 thìa bột cafe Trung Nguyên rang xay/xay thường\n50ml nước sôi\n50g đường trắng, 15ml sữa đặc ông Thọ\n60ml sữa tươi không đường\nĐá viên",
            "50ml nước lọc, 5ml nước đường, 30ml nước cốt chanh, 1gr vỏ chanh, đá viên",
            "sữa chua Vinamilk có đường : 1 hộp\nSữa đặc : 30ml\nRick's: 20ml\nCam : 2 lát\nPhúc bồn tử : 2 trái",
            "10 nụ hoa hồng sấy khô\n10 gam gừng\n15ml mật ong\n1 gói trà túi lọc\nNước sạch",
            "5 – 7 quả vải ngâm đường hoặc vải tươi\n3gr trà đen hoặc trà Earl Grey\n10ml nước cốt chanh\n10ml đường nước\n100gr đường cát\n10ml syrup vải\nĐá viên\nLá bạc hà\nSả cây"
    };

    @GetMapping("/drinks_material")
    private String[] drinks_material() {
        return drinks_material;
    }
    String[] drinks_method = {"Cho lần lượt đá, cà phê, sữa đặc, bột Frappe, bột sữa vào máy xay trong vòng 15-20s cho nhuyễn, mịn.\nCho hỗn hợp cappuchino đá xay ra ly, trang trí bằng lớp Milk Cap cùng với hạt cà phê và rắc ít bột cacao lên trên mặt\nCách làm lớp Milk Cap: đong 25gr bột Milk Cap và 60ml nước lọc (hoặc sữa tươi không đường), khuấy đều hỗn hợp trong vòng 30-40s",

            "+ Bước 1: Pha cà phê: Đầu tiên, cho vào phin 1.5 muỗng canh bột cà phê, 30ml nước sôi rồi ủ trong 20 giây. Sau 20 giây, bạn dùng tay ấn mạnh tim gài xuống để nén cà phê.Kế đến, cho vào thêm 70ml nước sôi và tiếp tục ủ đến khi nước cà phê chảy ra hết.Cuối cùng, dùng tay nén chặt tim gài 1 lần nữa để ép ra hết phần nước cốt là hoàn tất.\n+Bước 2: Xay hỗn hợp nguyên liệu: Cho vào máy xay sinh tố phần nước cốt cà phê, 20ml siro caramel, 50ml sữa tươi không đường, 30gr topping cream, 1 ít nước đá đông lạnh. Xay hỗn hợp từ 15 - 30 giây đến khi nhuyễn, mịn hoàn toàn\n+Bước 3: Hoàn thành: Cho hỗn hợp đá xay ra ly, trang trí lên mặt 1 ít whipping cream đã đánh bông cứng, 1 ít siro caramel là hoàn tất.",

            "+ Bước 1: Dùng nước sôi tráng qua phin cà phê, bạn cần tráng kỹ cả nắp phin và gạt phin nhé, để làm tăng nhiệt độ của phin, từ đó khi pha thì cafe sẽ nhận được lượng nhiệt chuẩn nhất.\nĐây là bước bị mọi người bỏ qua rất nhiều vì nghĩ rằng bước này không quan trọng. Tuy nhiên để có được một lý cafe đen nóng ngon thì các bạn không nên bỏ qua. Cách pha cafe đen chuẩn vị thì bắt buộc các bạn phải qua bước này.\n + Bước 2: Cho cafe vào phin sau đó lắc nhẹ phin để cafe dàn đều, rồi ấn nhẹ nắp gài phin, bạn cần lưu ý nên ấn một lượng vừa phải, không nên ấn chặt sẽ khiến cafe quá đậm, ấn nhẹ sẽ khiến cafe bị nhạt.\n+ Bước 3: Ủ cafe: Rót 160ml nước sôi 100 độ vào phin, rưới từ từ theo vòng tròn vào phần gài phin được khoảng 20% nước sôi thì dừng lại, chờ 30 – 60 giây để cafe ngấm rồi mới tiếp tục ró 80% nước sôi còn lại cho đến khi hết nước. Sau đó chờ cho cafe hòa hết nước.\nBước ủ cafe này là bước quan trọng nhất trong cách pha cafe đen để có ly cafe thơm ngon, nếu sau khi rót hết nước sôi, bạn quan sát thấy cà phê nhỏ từng giọt một mỗi giây thì coi như bạn đã thành công phân nửa, còn nếu cafe nhỏ thành dòng tức là bạn đa ấn chặn cafe không đủ chặt, sẽ khiến cafe bị loãng.\nNgoài ra bạn cũng nên lưu ý rằng cafe đen nguyên chất có độ nở khá cao, nên bạn cần chú ý trong quá trình ủ cafe xem phần nắng gài phin bị bung thì cần ấn chặt lại như cũ ngay, tránh trường hợp cafe bị nhạt.",

            "+ Bước 1: Tráng qua các dụng cụ pha cà phê: phin, ly, tách. Việc này làm dụng cụ nóng đều sẽ cho ly cà phê ngon hơn.\n+ Bước 2: Cho sữa đặc vào ly pha cafe. Thông thường, với mỗi phin cà phê, bạn nên cho khoảng 2-3 muỗng sữa đặc. Có thể điều chỉnh lượng sữa theo khẩu vị của mình. (Bạn cũng có thể cho sữa vào cà phê sau khi pha xong).\n+Bước 3 : Cho bột cà phê vào phin. Lắc nhẹ để mặt cà phê phẳng. Đặt phin cà phê lên ly cafe. Dùng tấm nén ép nhẹ bột cafe xuống. Nên nén vừa đủ để cà phê chảy chậm mà không bị nghẽn nước.\n+ Bước 4: Để nước giảm nhiệt độ giảm đến 93-95 độ C (để 1-2 phút sau khi đun sôi), rót nước vừa cao hơn mặt cà phê để ủ. Bạn có thể đặt phin lên nắp phin, rót ít nước sôi vào nắp để cà phê hấp thụ nước nóng từ bên dưới. Điều này giúp các tầng của cà phê thấm đều nước, giúp cà phê ngon hơn.\n + Bước 5: Sau khoảng 1-2 phút, rót nước đến gần đầy phin rồi đậy nắp phin lại.\n+ Bước 6: Đợi khoảng 3-5 phút cà phê sẽ chảy xong. Khuấy đều cà phê và sữa đặc. Bạn cũng có thể cho sữa vào ở bước này rồi khuấy. Cho cà phê sữa vào ly đá đã chuẩn bị sẵn. Vậy là bạn có thể thưởng thức ly cà phê sữa đá thơm ngon do mình pha rồi đó.",

            "Pha hồng trà với 200ml nước nóng khoảng 90 độ C, đậy nắp và đợi trong khoảng 5-10 phút để trà ngấm. Sau đó lọc bã trà lấy nước cốt, để nguội phần nước cốt hồng trà này.\nVắt ½ quả chanh lấy nước, bỏ hạt. ½ quả chanh còn lại cắt lát mỏng.\nCho hồng trà đã để nguội bớt vào bình lắc, thêm nước chanh và đường (hoặc mật ong) vào khuấy đều cho tan hết.\nCho đá viên cùng 1 nhánh bạc hà vào bình lắc, đậy nắp lại và lắc khoảng 10 lần.\nThả 2 lát chanh vào ly, rót trà vào ly, trang trí 1 lát chanh và 1 nhánh bạc hà lên miệng ly là hoàn thành.\nHồng trà chanh đá có màu nâu cam đẹp mắt, vị trà chua ngọt sảng khoải, vị trà đen đậm đà nổi bật. Trên miệng ly có một lớp bọt nhẹ.",

            "+ Bước 1: Làm bọt cafe : Cho bột cafe vào phin, chế nước sôi vào rồi đậy lại. Đợi một lúc để lấy phần nước cốt cafe.\nCho 25g đường và phần nước cốt cafe vào tô. Dùng phới đánh trứng đánh cho đường tan và tạo thành hỗn hợp sánh mịn, có màu nâu đậm.\nCho 25g đường còn lại vào đánh chung cho đến khi tạo được lớp bọt mịn có màu nâu nhạt, bông đều và có chóp là được.\n+ Bước 2 : Làm cafe bọt biển 3 màu đẹp mắt : ho phần sữa đặc vào đáy ly rồi chế sữa tươi không đường lên trên tạo thành lớp sữa 2 màu.\nĐổ đá viên vào, cuối cùng là rưới từ từ lớp bọt cafe lên trên cùng.\n+ Cuối cùng : sau khi hoàn thành cách làm cafe bọt biển không cần máy đánh trứng trên đây, bạn chỉ việc thưởng thức thành quả của mình. Đảm bảo ly cafe bọt biển mà bạn tự pha sẽ cực kỳ lôi cuốn và “đã” miệng!",

            "+ Bước 1: Chanh vắt lấy 30ml nước cốt, khoảng 2 trái. Sau đó dùng 1 vỏ chanh \n+ Bước 2: Cho lần lượt vào cối xay sinh tố 50ml nước lọc, 5ml nước đường, 30ml nước cốt chanh, 1 vỏ chanh và đá viên. Xay thật nhuyễn hỗn hợp.\n+ Bước 3: Cẩn thận rót ra ly và cho lớp đá tuyết bồng bềnh lên trên ly để làm đồ uống thêm phần hấp dẫn.",

            "Đầu tiên, bạn xay nhuyễn hỗn hợp kem Rick’s, sữa đặc, sữa chua với đá trên cối đá xay.\nCho Phúc Bồn Tử vào đáy ly, sau đó đổ hỗn hợp vào đầy ly\nCuối cùng bạn chỉ cần trang trí vài lát cam và quả Phúc Bồn Tử là đã có ngay một công thức Sữa Chua Phúc Bồn Tử tuyệt ngon rồi.\n(*) Cách làm nước cốt Phúc Bồn Tử Golden Tree: Xay 200gr phúc bồn tử với 300ml nước sau đó lọc qua rây lấy nước cốt. Lưu ý nước cốt nếu không sử dụng hết có thể để trong ngăn mát tủ lạnh dùng từ 3 - 5 ngày.",

            "+ Bước 1: Gừng rửa sạch, cạo vỏ và cắt thành từng lát mỏng.\n+ Bước 2: Cho nước sạch vào ấm đun sôi.\n+ Bước 3: Đổ nước sôi vào ly thủy tinh để ngâm trà túi lọc trong khoảng 2 phút rồi lấy ra để lấy nước.\n+ Bước 4: Cho gừng và nụ hoa hồng khô vào trong ấm trà, ngâm trong khoảng 8 – 10 phút cho ra nước.\n+ Bước 5: Khi uống, bạn rót trà ra tách rồi cho thêm chút mật ong vào nếu muốn uống trà hoa hồng mật ong. \nNếu thích, bạn có thể cắt thêm một lát chanh cho vào tách trà và uống nóng hoặc uống lạnh đều được.",

            "+ Bước 1 : Cách ủ trà thơm nồng: Đầu tiên, bạn dùng nước sôi có nhiệt độ khoảng 90 độ C (đối với trà đen). Ở nhiệt độ này, trà sẽ được chiết xuất trọn vẹn mùi hương, không để lại vị chát hoặc đắng. Bạn ủ trà khoảng 10 phút là được. Sau đó, để nguội nước cốt trà.\n+ Bước 2: Cách làm vải ngâm đường: Bạn hòa tan khoảng 100gr đường với 300ml nước lọc sau đó dùng muỗng khuấy đều để đường tan hoàn toàn. Bạn chọn những quả vải tươi ngon nhất bóc vỏ, bỏ hạt và ngâm phần thịt vải ngập trong nước đường này.\n+ Bước 3: Hoàn thiện thành phẩm: Bạn cho khoảng 1/3 lượng nước đường vải đã để nguội vào ly, rót thêm 80ml trà, 10ml nước cốt chanh, 10ml syrup vải (nếu bạn cho nước vải ngâm thì không cần cho syrup vải vào), một ít sả cắt nhỏ. Sau đó bạn khuấy nhẹ và thêm đá viên, vải ngâm vào. Bạn cũng có thể shake lên để thức uống được hòa quyện với nhau rồi rót ra ly, trang trí thêm cho thức uống bằng một vài lá bạc hà tươi."
    };

    @GetMapping("/drinks_method")
    private String[] drinks_method() {
        return drinks_method;
    }
    String[] drinks_location = {"296 Hòa Bình, Phú Thạnh, Tân Phú, Thành phố Hồ Chí Minh",

            "45 Đ. Lê Văn Huân, Phường 13, Tân Bình, Thành phố Hồ Chí Minh",

            "330 Phan Đình Phùng, Phường 1, Phú Nhuận, Thành phố Hồ Chí Minh",

            "3 Đường Trần Hưng Đạo, Tân Thành, Tân Phú, Thành phố Hồ Chí Minh",

            "18E Cộng Hòa, Phường 4, Tân Bình, Thành phố Hồ Chí Minh",

            "180 Thạch Lam, Phú Thạnh, Tân Phú, Thành phố Hồ Chí Minh",

            "247 Lý Thường Kiệt, Phường 6, Tân Bình, Thành phố Hồ Chí Minh",

            "299 Đường số 7, Bình Trị Đông B, Bình Tân, Thành phố Hồ Chí Minh",

            "55 Đ. Vườn Lài, Phú Thọ Hoà, Tân Phú, Thành phố Hồ Chí Minh",

            "296 Hòa Bình, Phú Thạnh, Tân Phú, Thành phố Hồ Chí Minh"

    };

    @GetMapping("/drinks_location")
    private String[] drinks_location() {
        return drinks_location;
    }
}
