USE truyencuoi;

INSERT INTO topics (id, title, emoji, description, sort_order) VALUES
('study', 'Việc học', '📚', 'Những câu chuyện nhẹ nhàng về lớp học và bài tập.', 1),
('family', 'Gia đình', '👪', 'Chuyện vui trong nhà chưa kể.', 2),
('office', 'Công sở', '💼', 'Chuyện bàn giấy, họp hành hài hước.', 3),
('love', 'Tình yêu', '💕', 'Những khoảnh khắc tim đập và... muốn cười.', 4),
('daily', 'Đời sống', '🌳', 'Kể chuyện vặt mà vui không tưởng.', 5),
('dating_dentist', 'Truyện cười hẹn hò với nha sĩ', '🦷', 'Chủ đề đặc biệt về câu chuyện hẹn hò với nha sĩ.', 6);

INSERT INTO stories (topic_id, title, content, position) VALUES
('study', 'Bài học vỡ lòng', 'Cô giáo hỏi: "2 + 2 bằng mấy?". Tí trả lời: "Bằng 4 ạ". Cô khen: "Giỏi quá, ai dạy em thế?". Tí đáp: "Dạ bố em, nhưng bố bảo đừng nói với cô là bố làm hộ bài".', 1),
('study', 'Thước đo thông minh', 'Trong giờ kiểm tra, Nam thì thầm: "Cho tớ chép với". Hùng đáp: "Không được đâu, cô dặn phải độc lập". Nam cười: "Thì tớ độc lập với cậu, chỉ là giống nhau thôi".', 2),
('study', 'Sổ đầu bài', 'Mẹ hỏi: "Hôm nay cô phê gì trong sổ?". Bin trả lời: "Cô viết: ''Cần cải thiện'' ạ". Mẹ thở dài: "Lại thế nữa". Bin cười: "Nhưng cô viết đẹp lắm mẹ ạ, con giữ sổ cho mẹ xem".', 3),

('family', 'Bố và điều khiển', 'Bố nói: "Nhà này bố là người điều khiển tivi". Con trai cãi: "Nhưng điều khiển đang ở tay con rồi". Bố thở dài: "Thì bố điều khiển... bằng lời nói".', 1),
('family', 'Mẹ và thực đơn', 'Mẹ hỏi cả nhà thích ăn gì. Ai cũng trả lời "gì cũng được". Mẹ bèn nấu món bí đỏ luộc. Cả nhà đồng thanh: "Sao lại món này?". Mẹ mỉm cười: "Vì món này có tên ''Gì cũng được''".', 2),
('family', 'Em bé thông minh', 'Anh hỏi em: "Em yêu ai nhất nhà?". Bé nghĩ rồi bảo: "Em yêu mẹ nhất". Anh hỏi: "Còn anh?". Bé đáp: "Anh cũng yêu mẹ như em đúng không?".', 3),

('office', 'Họp online', 'Sếp hỏi: "Sao em tắt camera?". Nhân viên đáp: "Do mạng yếu ạ". Con mèo phía sau trả lời thay: "Mạng yếu nhưng ngủ vẫn khỏe".', 1),
('office', 'Deadline', 'Bạn đồng nghiệp bảo: "Có bí quyết gì hoàn thành deadline không?". Tôi nói: "Có, đừng mở mạng xã hội". Bạn ấy thở dài: "Nhưng em vừa đọc bí quyết đó trên mạng xã hội".', 2),
('office', 'Bàn làm việc gọn gàng', 'Sếp khen: "Bàn em lúc nào cũng gọn". Tôi đáp: "Dạ vì hồ sơ em lưu ở desktop".', 3),

('love', 'Tin nhắn bí ẩn', 'Cô gái nhắn: "Anh đang làm gì?". Chàng trai trả lời: "Anh đang đọc sách". 5 phút sau cô gửi ảnh selfie và hỏi: "Thấy gì không?". Anh trả lời: "Thấy chữ ''đẹp'' to đùng".', 1),
('love', 'Hẹn hò tiết kiệm', 'Cô gái hỏi: "Anh sẽ đưa em đi đâu?". Anh đáp: "Đi siêu thị". Cô nhăn mặt: "Lãng mạn gì chứ". Anh cười: "Ở đó có điều hòa, wifi và xe đẩy miễn phí".', 2),
('love', 'Ghen tuông hiện đại', 'Cô gái trách: "Sao anh like ảnh người ta?". Anh nói: "Tay anh trượt". Cô đáp: "Tay anh trượt nhưng tim em trúng".', 3),

('daily', 'Tiết kiệm điện', 'Bạn cùng phòng bảo: "Tắt đèn đi ngủ cho tiết kiệm". Tôi nói: "OK", rồi bật màn hình điện thoại sáng trưng cả đêm.', 1),
('daily', 'Bí kíp nấu ăn', 'Mẹ gọi điện hỏi: "Con nấu thế nào rồi?". Tôi trả lời: "Con đang theo công thức của Google". Mẹ hét: "Google có ăn đâu mà biết".', 2),
('daily', 'Thức dậy đúng giờ', 'Đồng hồ báo thức reo. Tôi tắt và tự nhủ: "Ngủ thêm 5 phút". Khi mở mắt đã thấy thành 5 câu chuyện kể lại cho đồng nghiệp.', 3),

('dating_dentist', 'Hẹn hò với nha sĩ', 'Tý rung rợn một anh chàng nha sĩ trẻ, đẹp trai. Thế nên cô thường lấy nguyên do đi nhổ răng để lên lúc đến gặp anh ta. Một hôm, chàng nha sĩ rầu rĩ nói:\n\n- Anh nghĩ chúng ta nên dừng lại thôi, chắc chồng em cũng có thể đã bắt đầu nghi ngờ rồi.\n\nTý ngạc nhiên:\n\n- Làm gì có chuyện đó, chúng ta đã hẹn hò được một năm nay rồi mà chồng em có nói gì đâu.\n\nChàng nha sĩ khẽ lắc đầu:\n\n- Nhưng em còn có 1 cái răng thôi, lần sau biết lấy nguyên do gì để đến gặp anh nữa chứ?\n\n- !!!\n\nTruyện cười thú vị về câu chuyện hẹn hò với nha sĩ.', 1),
('dating_dentist', 'Lịch hẹn đặc biệt', 'Cô gái nhắn: "Anh rảnh tối nay không?". Anh nha sĩ đáp: "Anh bận khám". Cô nói: "Vậy em book lịch nhổ răng khôn, nhổ xong mình đi ăn". Anh ngạc nhiên: "Em còn răng khôn nào đâu?". Cô cười: "Thì mình nhổ lịch cho có cớ gặp nhau thôi".', 2),
('dating_dentist', 'Sợ kim', 'Anh nha sĩ trấn an: "Chích nhẹ tí thôi". Cô gái nhắm mắt: "Em chỉ sợ kim". Anh hỏi: "Thế sao em vẫn thích anh?". Cô đáp: "Vì anh là kim... chiếu yêu, gặp anh là mê luôn".', 3),
('dating_dentist', 'Quà tặng kỳ lạ', 'Sinh nhật anh, cô tặng một hộp kẹo siêu ngọt. Anh nhăn mặt: "Em muốn anh phá sản mua dụng cụ chữa sâu răng cho khách à?". Cô cười: "Không, em muốn anh thử cảm giác bệnh nhân để thương tụi em hơn".', 4),
('dating_dentist', 'Tin nhắn lúc nửa đêm', '12 giờ đêm, cô nhắn: "Anh ngủ chưa?". Anh đáp: "Chưa, đang soạn bệnh án". Cô gửi tấm ảnh cười tươi: "Răng em đau quá, phải qua khám gấp". Anh lo lắng: "Đau ở đâu?". Cô trả lời: "Ở tim vì nhớ anh".', 5),
('dating_dentist', 'Cạnh tranh nghề nghiệp', 'Bạn trai hỏi: "Sao em cứ tới nha sĩ hoài?". Cô đáp: "Vì anh ấy làm em cười suốt". Bạn trai ghen: "Anh cũng làm em cười mà". Cô bảo: "Nhưng anh làm em đau bụng, còn nha sĩ làm em đau răng".', 6),
('dating_dentist', 'Combo giảm giá', 'Phòng khám có khuyến mãi: dẫn người yêu tới được giảm 20%. Cô lập tức dắt anh vào ghế: "Em muốn trám tình yêu chúng mình". Anh cười: "Anh chỉ có gói trám răng thôi".', 7),
('dating_dentist', 'Tấm hình chụp X-quang', 'Anh gửi cô tấm hình chụp X-quang và nói: "Trái tim anh ở đây". Cô hỏi: "Sao toàn xương hàm?". Anh đáp: "Vì trong tim anh toàn nụ cười của em".', 8),
('dating_dentist', 'Ghen với bệnh nhân', 'Cô trách: "Hôm nay anh cười với bệnh nhân nữ nhiều quá". Anh giải thích: "Vì làm họ cười thì mới dễ khám". Cô dỗi: "Từ nay anh chỉ được làm em cười thôi".', 9),
('dating_dentist', 'Hứa hẹn', 'Anh bảo: "Mai anh có ca nhổ răng sớm". Cô hỏi: "Có đau không?". Anh cười: "Anh quen rồi". Cô nắm tay: "Vậy sau khi nhổ xong, anh nhớ cười với em, để em biết dù đau mấy anh vẫn hẹn em".', 10);

