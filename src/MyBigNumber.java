import java.util.logging.Logger;

public class MyBigNumber {
    private static final Logger logger = Logger.getLogger(MyBigNumber.class.getName());

    public String sum(String stn1, String stn2) {
        StringBuilder result = new StringBuilder();
        int len1 = stn1.length();
        int len2 = stn2.length();
        int carry = 0; // Biến nhớ

        // Duyệt từ cuối chuỗi về đầu
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int digit1 = i < len1 ? stn1.charAt(len1 - 1 - i) - '0' : 0;
            int digit2 = i < len2 ? stn2.charAt(len2 - 1 - i) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10; // Lấy giá trị nhớ

            result.insert(0, sum % 10); // Thêm chữ số vào kết quả

            // Ghi nhận lại lịch sử phép toán
            logger.info("Step " + (i + 1) + ": " + digit1 + " + " + digit2 + " + " + carry + " = " + sum
                    + ", lưu " + (sum % 10) + ", nhớ " + carry);
        }

        // Nếu còn giá trị nhớ thì thêm vào đầu kết quả
        if (carry != 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MyBigNumber myBigNumber = new MyBigNumber();
        System.out.println(myBigNumber.sum("1234", "897")); // Output: 2131
    }
}
