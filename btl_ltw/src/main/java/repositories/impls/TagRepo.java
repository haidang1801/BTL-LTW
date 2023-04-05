package repositories.impls;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Tag;
import repositories.interfaces.ITagRepo;
import repositories.utils.SQLInjection;
import repositories.utils.models.LogicalClause;
import repositories.utils.models.LogicalObject;
import repositories.utils.models.LogicalObjectType;

public class TagRepo extends Repo<Tag> implements ITagRepo {
    public TagRepo() {
        super();
    }

    @Override
    public Tag Get(UUID id) throws SQLException {
        Tag response = null;
        try {
            LogicalObject obj1 = new LogicalObject("id", LogicalObjectType.FIELD);
            LogicalObject obj2 = new LogicalObject(id.toString(), LogicalObjectType.STRING);
            LogicalClause logicalClause = new LogicalClause(obj1, "=", obj2);
            LogicalClause[] logicalClauseArray = { logicalClause };
            CreateConnection();
            String sql = SQLInjection.SELECTSQL(null, "tags")+ SQLInjection.WHERESQL(logicalClauseArray)
                    + " ;";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                response = setObjectFromResultSet(resultSet);
            }

        } catch (Exception ex) {
        } finally{
            connection.close();
            statement.close();
        }
        return response;
    }

    @Override
    public List<Tag> Gets(String WhereSQL, String PaginSQL) throws SQLException {
        List<Tag> response = null;
        try {
            CreateConnection();
            String sql = SQLInjection.SELECTSQL(null, "tags ") + WhereSQL + " " + PaginSQL + " ;";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            response = new ArrayList<Tag>();
            while (resultSet.next()) {
                var tag = setObjectFromResultSet(resultSet);
                response.add(tag);
            }

        } catch (Exception ex) {
        } finally{
            connection.close();
            statement.close();
        }
        return response;
    }

    @Override
    public int Add(Tag record) throws SQLException {
        int response = 0;
        try {
            sql = record.GetInsertSQL(); CreateConnection();
            statement = connection.prepareStatement(sql);
            response = statement.executeUpdate();
        } catch (Exception ex) {
        } finally{
            connection.close();
            statement.close();
        }
        return response;
    }

    @Override
    public int Update(Tag record) throws SQLException {
        int response = 0;
        try {
            sql = record.GetUpdateSQL(); CreateConnection();
            statement = connection.prepareStatement(sql);
            response = statement.executeUpdate();
        } catch (Exception ex) {
        } finally{
            connection.close();
            statement.close();
        }
        return response;
    }

    @Override
    public int Delete(Tag record) throws SQLException {
        int response = 0;
        try {
            sql = record.GetDeteleSQL(); CreateConnection();
            statement = connection.prepareStatement(sql);
            response = statement.executeUpdate();
        } catch (Exception ex) {
        } finally{
            connection.close();
            statement.close();
        }
        return response;
    }

    @Override
    protected Tag setObjectFromResultSet(ResultSet resultSet) throws SQLException {
        var response = new Tag();
        response.set(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("tag_name"));
        return response;
    }

}
