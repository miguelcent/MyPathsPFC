
package mcm.projects.mypaths.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.PersistenceManager;

public final class PMF {
  
//    @SuppressWarnings("rawtypes")
//    private static final java.lang.Class[] classes = 
//      new java.lang.Class[] {com.metadot.book.connectr.server.domain.FeedInfo.class, 
//        com.metadot.book.connectr.server.domain.StreamItem.class,
//        com.metadot.book.connectr.server.domain.Friend.class};
    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PMF() {
    }

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
    
//    @SuppressWarnings("rawtypes")
//    public static java.lang.Class[] getClasses() {
//      return classes;
//    }
    
 
}
