package com.example.assignmentdatabasedesign;

import android.os.AsyncTask;

import java.util.List;

public class DatabaseAsyncTask extends AsyncTask<Void, Void, List<User>> {
    private LocalDatabase database;
    private UserDAO userDAO;
    private User user;
    private UserCallBack userCallBack;
    private int operationType;

    public DatabaseAsyncTask(UserDAO userDAO, int operationType,User user,UserCallBack userCallBack) {
        this.userDAO = userDAO;
        this.operationType = operationType;
        this.user = user;
        this.userCallBack = userCallBack;
    }

    @Override
    protected List<User> doInBackground(Void... voids) {
        switch (operationType) {
            case 1:
                // Insert User
                if (user != null) {
                    userDAO.insert(user);
                }
                break;
            case 2:
                // Get all users
                return userDAO.getAllUsers();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<User> users) {
      //  super.onPostExecute(users);
        userCallBack.onUserLoaded(users);
    }
}

