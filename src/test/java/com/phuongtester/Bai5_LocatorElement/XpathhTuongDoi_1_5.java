package com.phuongtester.Bai5_LocatorElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathhTuongDoi_1_5 {
    public static void main(String[] args) {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang anhtester.com
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Cách 1: Xác định bằng thuộc tính "@"
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Cách 2: Xác định bằng chuỗi text bằng hàm text()
        //text() lấy đúng khoảng trắng
        //normalize-space() bỏ qua khoảng trắng (chỉ cần đúng text là được)
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click(); // nút Login

        //Cách 3: Xác định với hàm contains() gồm thuộc tính và text - Tìm kiếm nhiều phần tử cùng loại
        driver.findElement(By.xpath("//label[contains(normalize-space(),'Remember')]")).click(); // nút Ghi nhớ đăng nhập
        driver.findElement(By.xpath("//a[contains(@href,'forgot_password')]")).click(); // nút Quên mật khẩu

        //Cách 4: Xác định với hàm starts-with gồm thuộc tính và text - Tìm kiếm nhiều phần tử có bắt đầu giống nhau
        System.out.println(driver.findElement(By.xpath("//h1[starts-with(@class,'tw')]")).getText()); // Tiêu đề trang
        System.out.println(driver.findElement(By.xpath("//h1[starts-with(normalize-space(),'Login')]")).getText()); // Tiêu đề trang


        //Tắt browser
        driver.quit();
    }
}
