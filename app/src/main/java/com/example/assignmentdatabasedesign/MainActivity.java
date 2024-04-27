package com.example.assignmentdatabasedesign;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LocalDatabase database;
    private OrderDAO orderDAO;
    private UserDAO userDAO;
    private CategoryDAO categoryDAO;
    private ContentDAO contentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        database = LocalDatabase.getInstance(getApplicationContext());
        orderDAO = database.orderDAO();
        userDAO = database.userDAO();
        categoryDAO = database.categoryDAO();
        contentDAO = database.contentDAO();
        // Instantiate UserCallBack as an anonymous inner class
        UserCallBack userCallBack = new UserCallBack() {
            @Override
            public void onUserLoaded(List<User> users) {
                // Handle the loaded users here
                // For example, update the UI with the loaded users
                // users contains the list of all users retrieved from the database
            }
        };

// Instantiate DatabaseAsyncTask with UserDAO, operation type 2, and UserCallBack
        DatabaseAsyncTask task = new DatabaseAsyncTask(userDAO, 2, null, userCallBack);

// Execute the task
        task.execute();

        // userDAO.deleteAllUsers();
      //  categoryDAO.deleteAllCategories();
       // contentDAO.deleteAllContents();
       // orderDAO.deleteAllOrders();

        List<Order> orderList = orderDAO.getAllOrders();//you must invoke any DAO instance to allow database connection stay open
/*
        User user = new User();
        user.setFirstname("John");
        user.setLastname("Wick");
        user.setUsername("Hitman@com");
        user.setPassword("1234");
        user.setRole("admin");
        userDAO.insert(user);


        Category category = new Category();
        category.setName("Hotel");
        category.setCategory_resID(
                getResources().getIdentifier("hitanami","drawable",getPackageName())
        );
        categoryDAO.insert(category);


        Content content = new Content();
        content.setName("Best Hotel");
        content.setCategory_id(1);
        content.setContent_resID(
                getResources().getIdentifier("hitanami","drawable",getPackageName())
        );
        contentDAO.insert(content);


        Order order = new Order();
        order.setUser_id(1);
        order.setContent_id(1);
        order.setOrder_brief("hello");
        order.setOrder_quantity(3);
        orderDAO.insert(order);
*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}