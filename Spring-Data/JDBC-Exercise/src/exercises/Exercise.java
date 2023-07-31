package exercises;

import java.sql.SQLException;

public abstract class Exercise { // Base class

     protected Exercise () throws SQLException {}
     public abstract String execute() throws SQLException;
}
