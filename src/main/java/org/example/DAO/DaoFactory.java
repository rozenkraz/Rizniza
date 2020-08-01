package org.example.DAO;


    public class DaoFactory implements IDaoFactory{

        private static IDaoFactory factory;

        public DaoFactory() {
            try {
                Class.forName("org.h2.Driver");
                System.out.println("Driver is loaded succesfully!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }



        public static synchronized IDaoFactory getInstance() {
            if (factory == null) {
                factory = new DaoFactory();
            }
            return factory;
        }

        @Override
        public IPlace1Dao getPlace1() {
            return new Place1Dao();
        }



        @Override
        public IItemCollection1Dao getItemFromCollection1() {
            return new ItemCollection1Dao() ;
        }



        @Override
        public IISTablesDao getISTable() {
            return new ISTablesDao();
        }
    }

