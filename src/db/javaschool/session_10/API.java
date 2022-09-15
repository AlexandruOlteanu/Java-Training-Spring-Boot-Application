package db.javaschool.session_10;

import db.javaschool.session_8.Customer;
import db.javaschool.session_8.DatabaseManager;
import db.javaschool.session_8.Order;
import db.javaschool.session_9.Problems.ActiveRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import spark.Spark;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class API {
    public static void main(String[] args) throws FileNotFoundException {

        final DatabaseManager databaseManager = new DatabaseManager();
        final ActiveRecord activeRecord = new ActiveRecord(databaseManager);


        Spark.get("/customer/:id", ((request, response) -> {
            String id = request.params(":id");
            int ID = Integer.parseInt(id);
            Customer customer = databaseManager.getCustomerbyId(ID);

            Map<String, String> objectData = activeRecord.getDatabaseObjectData(customer, false);

            JSONObject obj = new JSONObject();
            obj.putAll(objectData);

            return obj.toJSONString();
        }));

        Spark.put("/customer", ((request, response) -> {

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(request.body());
            Customer customer = new Customer();
            activeRecord.setDatabaseObject(customer, obj);

            databaseManager.insertCustomer(customer);

            return "";

        }));

        Spark.delete("/customer/:id", ((request, response) -> {
            int id = Integer.parseInt(request.params(":id"));
            databaseManager.deleteCustomerById(id);
            return "";
        }));

        Spark.get("/customers", (((request, response) -> {
            List<Customer> customerList = databaseManager.getAllCustomers();
            JSONArray jsonArray = new JSONArray();
            for (Customer customer: customerList) {
                Map<String, String> objectData = activeRecord.getDatabaseObjectData(customer, false);
                JSONObject jsonObject = new JSONObject(objectData);
                jsonArray.add(jsonObject);
            }
            return jsonArray.toJSONString();
        })));

        Spark.get("/order/:id", ((request, response) -> {

            String id = request.params(":id");
            int ID = Integer.parseInt(id);
            Order order = databaseManager.getOrderById(ID);

            Map<String, String> objectData = activeRecord.getDatabaseObjectData(order, false);

            JSONObject obj = new JSONObject();
            obj.putAll(objectData);

            return obj.toJSONString();

        } ));

        Spark.put("/order", ((request, response) -> {

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(request.body());
            Order order = new Order();
            activeRecord.setDatabaseObject(order, obj);

            databaseManager.insertOrder(order);
            response.status(201);
            return "";

        } ));
    }
}
