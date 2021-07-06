public class DaoFactory {
    private static Ads adsDao;
    private static Products productsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

    public static Products getProductsDao() {
        // singleton pattern ; one single creation
        if (productsDao == null) {
            productsDao = new ListProducts(); // List Products has the Products interface implemented already ; Since our ado factory cannot instantiate an interface, it can instead instantiate a class that already implements the interface
        }
        return productsDao;
    }
}
