package ph.edu.dlsu;

import acm.graphics.GCanvas;
import acm.graphics.GImage;

public class MainCanvas extends GCanvas {

    public void homescreen() {
        GImage image = new GImage("assets/1.png");
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasConsultation() {
        GImage image = new GImage("assets/2.png");
        image.scale(1.01, 1.0);
        image.setLocation(0, 90);
        add(image);
    }

    public void canvasPhysical1() {
        GImage image = new GImage(new APhysical().displaySymptoms("assets/3.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasPhysical2() {
        GImage image = new GImage(new APhysical().displaySymptoms("assets/4.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasPhysical3() {
        GImage image = new GImage(new APhysical().displaySymptoms("assets/5.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasPhysical4() {
        GImage image = new GImage(new APhysical().displaySymptoms("assets/6.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasPhysical5() {
        GImage image = new GImage(new APhysical().displaySymptoms("assets/7.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasPhysical6() {
        GImage image = new GImage(new APhysical().displaySymptoms("assets/8.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasPhysical7() {
        GImage image = new GImage(new APhysical().displaySymptoms("assets/9.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasPhysical8() {
        GImage image = new GImage(new APhysical().displaySymptoms("assets/10.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasPhysical9() {
        GImage image = new GImage(new APhysical().displaySymptoms("assets/11.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void scanning() {
        GImage image = new GImage("assets/scanning.png");
        image.scale(0.7, 0.7);
        image.setLocation(0, 90);
        add(image);
    }

    public void Doc1() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc1name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(140, 150);
        add(name);

        GImage image = new GImage("assets/doc1.jpg");
        image.scale(0.68, 0.65);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc1text.png");
        text.scale(0.5, 0.5);
        text.setLocation(45, 490);
        add(text);
    }

    public void Doc2() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc2name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(120, 150);
        add(name);

        GImage image = new GImage("assets/doc2.jpg");
        image.scale(1.0, 1.0);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc2text.png");
        text.scale(0.5, 0.5);
        text.setLocation(90, 510);
        add(text);
    }

    public void Doc3() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc3name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(120, 150);
        add(name);

        GImage image = new GImage("assets/doc3.jpg");
        image.scale(0.69, 0.7);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc3text.png");
        text.scale(0.5, 0.5);
        text.setLocation(90, 500);
        add(text);
    }

    public void Doc4() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc4name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(120, 150);
        add(name);

        GImage image = new GImage("assets/doc4.jpg");
        image.scale(0.69, 0.7);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc4text.png");
        text.scale(0.5, 0.5);
        text.setLocation(90, 500);
        add(text);
    }

    public void Doc5() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc5name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(120, 150);
        add(name);

        GImage image = new GImage("assets/doc5.jpg");
        image.scale(0.69, 0.7);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc5text.png");
        text.scale(0.5, 0.5);
        text.setLocation(90, 500);
        add(text);
    }

    public void Doc6() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc6name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(100, 150);
        add(name);

        GImage image = new GImage("assets/doc6.jpg");
        image.scale(0.8, 0.7);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc6text.png");
        text.scale(0.5, 0.5);
        text.setLocation(55, 520);
        add(text);
    }

    public void Doc7() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc7name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(150, 150);
        add(name);

        GImage image = new GImage("assets/doc7.jpg");
        image.scale(0.8, 0.6);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc7text.png");
        text.scale(0.5, 0.5);
        text.setLocation(90, 500);
        add(text);
    }

    public void Doc8() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc8name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(130, 150);
        add(name);

        GImage image = new GImage("assets/doc8.jpg");
        image.scale(0.69, 0.7);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc8text.png");
        text.scale(0.5, 0.5);
        text.setLocation(90, 500);
        add(text);
    }

    public void Doc9() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc9name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(130, 150);
        add(name);

        GImage image = new GImage("assets/doc9.jpg");
        image.scale(0.98, 1.0);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc9text.png");
        text.scale(0.5, 0.5);
        text.setLocation(90, 500);
        add(text);
    }

    public void Doc10() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc10name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(100, 150);
        add(name);

        GImage image = new GImage("assets/doc10.jpg");
        image.scale(0.82, 0.8);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc10text.png");
        text.scale(0.5, 0.5);
        text.setLocation(100, 500);
        add(text);
    }

    public void Doc11() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc11name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(120, 150);
        add(name);

        GImage image = new GImage("assets/doc11.jpg");
        image.scale(0.8, 0.6);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc11text.png");
        text.scale(0.5, 0.5);
        text.setLocation(100, 500);
        add(text);
    }

    public void Doc12() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc12name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(100, 150);
        add(name);

        GImage image = new GImage("assets/doc12.jpg");
        image.scale(0.7, 0.7);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc12text.png");
        text.scale(0.5, 0.5);
        text.setLocation(100, 500);
        add(text);
    }

    public void Doc13() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc13name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(130, 150);
        add(name);

        GImage image = new GImage("assets/doc13.jpg");
        image.scale(1.0, 1.0);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc13text.png");
        text.scale(0.5, 0.5);
        text.setLocation(100, 500);
        add(text);
    }

    public void Doc14() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc14name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(125, 150);
        add(name);

        GImage image = new GImage("assets/doc14.jpg");
        image.scale(1.0, 1.0);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc14text.png");
        text.scale(0.5, 0.5);
        text.setLocation(80, 500);
        add(text);
    }

    public void Doc15() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc15name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(110, 150);
        add(name);

        GImage image = new GImage("assets/doc15.jpg");
        image.scale(1.0, 1.0);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc15text.png");
        text.scale(0.5, 0.5);
        text.setLocation(95, 500);
        add(text);
    }

    public void Doc16() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc16name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(110, 150);
        add(name);

        GImage image = new GImage("assets/doc16.jpg");
        image.scale(1.0, 1.0);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc16text.png");
        text.scale(0.5, 0.5);
        text.setLocation(95, 500);
        add(text);
    }

    public void Doc17() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc17name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(150, 150);
        add(name);

        GImage image = new GImage("assets/doc17.jpg");
        image.scale(1.0, 1.0);
        image.setLocation(0, 200);
        add(image);

        GImage text = new GImage("assets/doc17text.png");
        text.scale(0.5, 0.5);
        text.setLocation(95, 500);
        add(text);
    }

    public void Doc18() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc18name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(70, 150);
        add(name);

        GImage image = new GImage("assets/doc18.jpg");
        image.scale(0.903, 0.50);
        image.setLocation(0, 205);
        add(image);

        GImage text = new GImage("assets/doc18text.png");
        text.scale(0.5, 0.5);
        text.setLocation(75, 500);
        add(text);
    }

    public void Doc19() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc19name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(90, 150);
        add(name);

        GImage image = new GImage("assets/doc19.jpg");
        image.scale(0.903, 0.83);
        image.setLocation(0, 205);
        add(image);

        GImage text = new GImage("assets/doc19text.png");
        text.scale(0.5, 0.5);
        text.setLocation(75, 500);
        add(text);
    }

    public void Doc20() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc20name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(90, 150);
        add(name);

        GImage image = new GImage("assets/doc20.jpg");
        image.scale(0.7, 0.7);
        image.setLocation(0, 205);
        add(image);

        GImage text = new GImage("assets/doc20text.png");
        text.scale(0.5, 0.5);
        text.setLocation(75, 500);
        add(text);
    }

    public void Doc21() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc21name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(125, 150);
        add(name);

        GImage image = new GImage("assets/doc21.jpg");
        image.scale(1.0, 1.0);
        image.setLocation(0, 205);
        add(image);

        GImage text = new GImage("assets/doc21text.png");
        text.scale(0.5, 0.5);
        text.setLocation(75, 500);
        add(text);
    }

    public void Doc22() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc22name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(110, 150);
        add(name);

        GImage image = new GImage("assets/doc22.jpg");
        image.scale(1.0, 1.0);
        image.setLocation(0, 205);
        add(image);

        GImage text = new GImage("assets/doc22text.png");
        text.scale(0.5, 0.5);
        text.setLocation(85, 500);
        add(text);
    }

    public void Doc23() {
        GImage company = new GImage(new IDoctor().DisplayCompany("assets/1.png"));
        company.scale(0.5, 0.5);
        company.setLocation(120, -60);
        add(company);

        GImage name = new GImage(new IDoctor().DisplayName("assets/doc23name.png"));
        name.scale(0.3, 0.3);
        name.setLocation(90, 150);
        add(name);

        GImage image = new GImage("assets/doc23.jpg");
        image.scale(0.85, 0.8);
        image.setLocation(0, 205);
        add(image);

        GImage text = new GImage("assets/doc23text.png");
        text.scale(0.5, 0.5);
        text.setLocation(85, 500);
        add(text);
    }

    public void canvasBDO() {
        GImage image = new GImage("assets/bdo.png");
        image.scale(0.9, 0.9);
        image.setLocation(25, 100);
        add(image);
    }

    public void canvasPayMaya() {
        GImage image = new GImage("assets/paymaya.png");
        image.scale(1.0, 1.0);
        image.setLocation(5, 80);
        add(image);
    }

    public void canvasGCash() {
        GImage image = new GImage("assets/gcash.png");
        image.scale(1.0, 1.0);
        image.setLocation(0, 80);
        add(image);
    }

    public void disclaimer() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/disclaimer.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasS1() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/s1.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasS2() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/s2.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasS3() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/s3.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasS4() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/s4.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasS5() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/s5.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasS6() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/s6.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasS7() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/s7.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasS8() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/s8.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasS9() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/s9.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasSPrescription() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/sprescription.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasMental1() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/n1.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasMental2() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/n2.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasMental3() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/n3.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasCope1() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/n4.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasCope2() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/n5.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void canvasNPrescription() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/n6.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }

    public void hotline() {
        GImage image = new GImage(new AEmotional().displaySymptoms("assets/n7.png"));
        image.scale(1.01, 1.0);
        image.setLocation(-5, 90);
        add(image);
    }
}