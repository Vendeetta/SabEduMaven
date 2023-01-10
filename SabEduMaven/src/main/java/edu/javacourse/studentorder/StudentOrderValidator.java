package edu.javacourse.studentorder;

import edu.javacourse.studentorder.dao.StudentOrderDaoImpl;
import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.exception.DaoException;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validators.ChildrenValidator;
import edu.javacourse.studentorder.validators.CityRegisterValidator;
import edu.javacourse.studentorder.validators.StudentValidator;
import edu.javacourse.studentorder.validators.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private ChildrenValidator cv;
    private WeddingValidator wv;
    private CityRegisterValidator crv;
    private StudentValidator sv;
    private MailSender sm;

    public StudentOrderValidator() {
        this.cv = new ChildrenValidator();
        this.wv = new WeddingValidator();
        this.crv = new CityRegisterValidator();
        this.sv = new StudentValidator();
        this.sm = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    private void checkAll() {
        List<StudentOrder> so = null;
        try {
            so = readStudenstOrder();
            for (StudentOrder oneSO : so)
                if(oneSO != null)
                    checkOneOrder(oneSO);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public void checkOneOrder(StudentOrder so){
        AnswerCityRegister answerCityRegister = checkCityRegister(so);
        System.out.println(answerCityRegister.getItems());
//        AnswerWeddingRegister answerWeddingRegister = checkWedding(so);
//        AnswerChildrenRegister answerChildrenRegister = checkChildren(so);
//        AnswerStudentRegister answerStudentRegister = checkStudent(so);
//        sendMail(so);

    }
    public List<StudentOrder> readStudenstOrder() throws DaoException {
        return new StudentOrderDaoImpl().getStudentOrders();
    }
    public AnswerCityRegister checkCityRegister(StudentOrder so){
        return crv.checkCityRegister(so);
    }
    private AnswerStudentRegister checkStudent(StudentOrder so) {
        return sv.checkStudent(so);
    }

    private AnswerChildrenRegister checkChildren(StudentOrder so) {
       return cv.checkChildren(so);
    }

    private AnswerWeddingRegister checkWedding(StudentOrder so) {
        return wv.checkWedding(so);
    }

    private void sendMail(StudentOrder so) {
        System.out.println("Письмо отправлено по заявке №" + so.getStudentOrderId() + ". ");
    }
}
