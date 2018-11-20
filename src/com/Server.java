package com;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws NamingException, RemoteException, AlreadyBoundException, MalformedURLException {
        Context context = new InitialContext();
        context.rebind("rmi://localhost:1099/imath", new IMathImpl());
       //  context.bind("rmi:imath",new IMathImpl());
       // Naming.bind("imath",new IMathImpl());
    }
}

interface IMath extends Remote {
    int add(int a, int b) throws RemoteException;
    String getMessage(String s) throws RemoteException;
}

class IMathImpl extends UnicastRemoteObject implements IMath {
    protected IMathImpl() throws RemoteException {
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String getMessage(String s) {
        System.out.println(s);
        return s;
    }
}










































