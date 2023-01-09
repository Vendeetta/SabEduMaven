package edu.javacourse.studentorder;

import edu.javacourse.studentorder.dao.StudentOrderDaoImpl;
import edu.javacourse.studentorder.dao.StudentOrderDao;
import edu.javacourse.studentorder.domain.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {
//        SaveStudentOrder studentOrder = new SaveStudentOrder();
//        DictionaryDaoImpl dao = new DictionaryDaoImpl();
//        for (Street s : dao.findStreets("про")){
//            System.out.println(s.toString());
//        }
//        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
//        for (PassportOffice p : po){
//            System.out.println(p.getOfficeName());
//        }
//        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
//        for (RegisterOffice p : ro){
//            System.out.println(p.getOfficeName());
//        }
//        List<CountryArea> ca = new DictionaryDaoImpl().findAreas("");
//        for (CountryArea c : ca){
//            System.out.println(c.getAreaId() + " " + c.getAreaName());
//        }
//        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("010000000000");
//        for (CountryArea c : ca1){
//            System.out.println(c.getAreaId() + " " + c.getAreaName());
//        }
//        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020010000000");
//        for (CountryArea c : ca2){
//            System.out.println(c.getAreaId() + " " + c.getAreaName());
//        }
//        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010010000");
//        for (CountryArea c : ca3){
//            System.out.println(c.getAreaId() + " " + c.getAreaName());
//        }


//        StudentOrder s = buildStudentOrder(10);
        StudentOrderDao dao = new StudentOrderDaoImpl();
//        Long id = dao.saveStudentOrder(s);
//        System.out.println(id);
//        System.out.println();

        List<StudentOrder> soList = dao.getStudentOrders();
        for (StudentOrder so : soList){
            System.out.println(so);
        }
    }

    static long saveStudentOrder(SaveStudentOrder so){
        return 199;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice registerOffice1 = new RegisterOffice(1l, "", "");
        so.setMarriageOffice(registerOffice1);

        Street street = new Street(1L, "Street First");

        Address address = new Address("195000", street, "12", "", "142");

        //Муж
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice passportOffice1 = new PassportOffice(1l, "", "");
        husband.setIssueDepartment(passportOffice1);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L, ""));

        // Жена
        Adult wife = new Adult("Петрова", "Вероника", "Алекссевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice passportOffice2 = new PassportOffice(2l, "", "");
        wife.setIssueDepartment(passportOffice2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));

        // Ребенок
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 6, 11));
        RegisterOffice registerOffice2 = new RegisterOffice(2l, "", "");
        child1.setIssueDepartment(registerOffice2);
        child1.setAddress(address);
        // Ребенок
        Child child2 = new Child("Петров", "Евгений", "Викторович", LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice registerOffice3 = new RegisterOffice(3l, "", "");
        child2.setIssueDepartment(registerOffice3);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }
}