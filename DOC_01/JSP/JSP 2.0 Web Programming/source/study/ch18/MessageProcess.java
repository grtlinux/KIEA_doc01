package ch18.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller�� ���� �۾��� ó���� ���ù޾Ƽ� �۾��� ó��
public class MessageProcess implements CommandProcess {
    
    public String requestPro(HttpServletRequest request,HttpServletResponse response)
    throws Throwable {
        request.setAttribute("message", "��û �Ķ���ͷ� ���ɾ ����");
        return "/ch18/process.jsp";
    }
}