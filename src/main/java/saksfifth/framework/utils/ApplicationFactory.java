package saksfifth.framework.utils;

import saksfifth.framework.base.ApplicationController;

/**
 * Created by zakirkhan on 6/2/17.
 */
public class ApplicationFactory {

    private static ApplicationFactory instance = new ApplicationFactory();

    private ApplicationFactory(){}

    public static ApplicationFactory getInstance()
    {
        return instance;
    }
    ThreadLocal<ApplicationController> applicationThreadLocal = new ThreadLocal<ApplicationController>(){
        @Override
        protected ApplicationController initialValue(){
            return new ApplicationController();
        }
    };
    public ApplicationController getApplicationController(){
        return applicationThreadLocal.get();
    }

    public void remove(){
        applicationThreadLocal.remove();
    }
}

