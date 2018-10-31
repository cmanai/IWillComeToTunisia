package tn.celestialsoftware.iwillcometotunisia;

public class News {

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    String Title;
String price1;
String a;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    String b;
    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    String price2;
    String Desc;


    byte[] image;
    public News(String Title, String Desc,String price1,String price2,String a,String b) {

        this.Title = Title;
        this.Desc = Desc;
this.price1=price1;
        this.price2=price2;
        this.a=a;
        this.b=b;

    }


}
