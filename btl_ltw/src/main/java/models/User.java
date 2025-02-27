package models;

import java.util.Date;
import java.util.UUID;

import utils.JsonUtils;

public class User extends Table {
    public String name;
    public String phonenum;
    public String address;
    public UUID avatar_id;
    public boolean status;
    public Date created_time;
    public Date last_update_time;

    public User() {
        super();
        this.TableName = "users";
    }

    public void set(UUID id, String name, String phonenum, String address, UUID avatar_id, boolean status,
            Date created_time, Date last_update_time) {
        this.id = id;
        this.name = name;
        this.phonenum = phonenum;
        this.address = address;
        this.avatar_id = avatar_id;
        this.status = status;
        this.created_time = created_time;
        this.last_update_time = last_update_time;
    }

    public static String GetTableName() {
		return "users";
	}
    

    @Override
    public String Get_Insert_Fields_SQL() {
        return "id, name, phonenum, address, avatar_id, status, created_time, last_update_time";
    }

    @Override
    public String Get_Insert_Values_SQL() {
        return "gen_random_uuid(), '" + name + "', '" + phonenum + "', '" + address + "', '" + avatar_id + "', '"
                + status + "', '" + created_time + "', '" + last_update_time + "'";
    }

    @Override
    public String Get_Update_Values_SQL() {
        return "name = '" + name + "', phonenum = '" + phonenum + "', address = '" + address + "', avatar_id = '"
                + avatar_id + "', status = '" + status + "', created_time = '" + created_time
                + "', last_update_time = '" + last_update_time + "'";
    }public String To_Json_String() {
		return "{" +
				JsonUtils.PropToJson("id", id, true) +
				JsonUtils.PropToJson("name", name, true) +
				JsonUtils.PropToJson("phonenum", phonenum, true) +
                JsonUtils.PropToJson("address", address, true) +
				JsonUtils.PropToJson("avatar_id", avatar_id, true) +
                JsonUtils.PropToJson("status", status, false) +
				JsonUtils.PropToJson("created_time", created_time, true) +
                JsonUtils.PropToJson("last_update_time", last_update_time, true) +
				"}";
	}
}