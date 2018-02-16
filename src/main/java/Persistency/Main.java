package Persistency;

public class Main {
    public static void main(String[] args){
        BaseDAO bdao = new BaseDAO();

        try{
            bdao.getConnection();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
