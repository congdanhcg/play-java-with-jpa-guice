import DAO.DbModule;
import DAO.UserDAO;
import com.google.inject.Guice;
import com.google.inject.Injector;
import models.UserAccount;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by danh.tc on 7/17/2017.
 */
public class DbTest {

    @Test
    public void testDb() throws SQLException {
        Injector injector = Guice.createInjector(new DbModule());
        UserDAO userDAO = injector.getInstance(UserDAO.class);

        UserAccount example = new UserAccount();
        example.setOtherField("hello world");
        userDAO.save(example);

        UserAccount retrieved = userDAO.get(new Long(1) );

        Assert.assertEquals(example.getId(), retrieved.getId());
        Assert.assertEquals(example.getOtherField(), retrieved.getOtherField());
    }

}
