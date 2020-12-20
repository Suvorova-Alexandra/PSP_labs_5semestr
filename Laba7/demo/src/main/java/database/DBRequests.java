package database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBRequests extends HttpServlet {
    private ArrayList<String> paths;
    private ArrayList<String> countFiles;
    private ArrayList<Float> memory;
    private ArrayList<String> deleteString;

    public ArrayList<String> showFullPath(String str) throws SQLException {
        String string = "SELECT * FROM subcatalog a LEFT JOIN catalog b ON a.idCatalog = b.idCatalog LEFT JOIN file c ON a.idSubcatalog = c.idCatalog";
        Subcatalog catal = new Subcatalog();
        ResultSet list = catal.leftJoin();
        paths = new ArrayList<>();
        int flag = 0;
        while (list.next()) {

            if (list.getString("titleSubcatalog") != null) {
                int k = 0;
                if (list.getString("titleSubcatalog").equals(str)) {
                    String path = "/" + list.getString("titleCatalog") + "/" + list.getString("titleSubcatalog");
                    for (String s : paths) {
                        if (path.equals(s)) {
                            k++;
                        }
                    }
                    if (k == 0)
                        paths.add(path);
                    flag++;
                }
            }
            if (list.getString("titleCatalog") != null) {
                int k = 0;
                if (list.getString("titleCatalog").equals(str)) {
                    String path = "/" + list.getString("titleCatalog");
                    for (String s : paths) {
                        if (path.equals(s)) {
                            k++;
                        }
                    }
                    if (k == 0)
                        paths.add(path);
                    flag++;
                }
            }
            if (list.getString("titleFile") != null) {
                int k = 0;
                if (list.getString("titleFile").equals(str)) {
                    String path = "/" + list.getString("titleCatalog") + "/" + list.getString("titleSubcatalog") + "/" + list.getString("titleFile");
                    for (String s : paths) {
                        if (path.equals(s)) {
                            k++;
                        }
                    }
                    if (k == 0)
                        paths.add(path);
                    flag++;
                }
            }

        }
        if (paths.isEmpty()) {
            paths.add("No results");
        }
        return paths;
    }

    public void countInnerFiles(String tit) throws SQLException {
        Requests catal = new Requests();
        Subcatalog subcatalog = new Subcatalog();
        countFiles = new ArrayList<>();
        ResultSet lt = subcatalog.leftJoin();
        ArrayList<String[]> list = catal.leftJoinWhereSubcatalog(tit);
        ArrayList<String[]> list2 = catal.leftJoinWhereCatalog(tit);
        ArrayList<String[]> list3=catal.leftJoinWhereFile(tit);
        if(!list.isEmpty()){
            for(String[] item:list){
              String catalog=item[1];
              int sum=0;
                for(String[] item2:list){
                    if(item2[1].equals(catalog) && item2[3]!=null)
                    {
                        sum++;
                    }
                }
                countFiles.add(String.valueOf(sum));
            }
        }
        if(!list2.isEmpty()){
            int sum=0;
            for(String[] item:list2){
                    if(item[3]!=null)
                    {
                        sum++;
                    }
            }
            countFiles.add(String.valueOf(sum));
        }
        if(!list3.isEmpty()){
            for(String[] item:list3){
                String catalog=item[1];
                String subcat=item[2];
                for(String[] item2:list3){
                    if(item2[1].equals(catalog) && item2[2].equals(subcat))
                    {
                        countFiles.add("This is a file!");
                    }
                }

            }
        }
        if (countFiles.isEmpty()) {
            countFiles.add("No results");
        }

    }

    public void countMemory(String tit) throws SQLException {
        Requests catal = new Requests();
        Subcatalog subcatalog = new Subcatalog();
        Catalog cat = new Catalog();
        File file = new File();
        memory = new ArrayList<>();
        ResultSet lt = subcatalog.leftJoin();
        ArrayList<String[]> list = catal.leftJoinMemorySubcatalog(tit);
        ArrayList<String[]> list2 = catal.leftJoinMemoryCatalog(tit);
        ArrayList<String[]> list3 = catal.leftJoinMemoryFile(tit);
        if(!list.isEmpty()){
            for(String[] item:list){
                String catalog=item[1];
                float sum=0;
                for(String[] item2:list){
                    if(item2[1].equals(catalog) && item2[3]!=null)
                    {
                        sum+=Float.parseFloat(item2[4]);
                    }
                }
                memory.add(sum);
            }
        }
        if(!list2.isEmpty()){
            float sum=0;
            for(String[] item:list2){
                if(item[3]!=null)
                {
                    sum+=Float.parseFloat(item[4]);
                }
            }
            memory.add(sum);
        }
        if(!list3.isEmpty()){
            for(String[] item:list3){
                String catalog=item[1];
                String subcat=item[2];
                for(String[] item2:list3){
                    if(item2[1].equals(catalog) && item2[2].equals(subcat))
                    {
                        memory.add(Float.parseFloat(item2[4]));
                    }
                }

            }
        }
        if (memory.isEmpty()) {
            memory.add((float) 0);
        }

    }

    public void deleteFiles(String tit) throws SQLException {
        Requests catal = new Requests();
        Subcatalog subcatalog = new Subcatalog();
        Catalog cat = new Catalog();
        File file = new File();
        deleteString=new ArrayList<>();
        ArrayList<String[]> list = catal.leftJoinMemorySubcatalog(tit);
        ArrayList<String[]> list2 = catal.leftJoinMemoryCatalog(tit);
        ArrayList<String[]> list3 = catal.leftJoinMemoryFile(tit);

        if(!list.isEmpty()){
            for(String[] item:list){
                String catalog=item[1];
                int sum=0;
                for(String[] item2:list){
                    if(item2[1].equals(catalog) && item2[3]!=null)
                    {
                        sum++;
                    }
                }

            }
        }
        if(!list2.isEmpty()){
            int sum=0;
            for(String[] item:list2){
                if(item[3]!=null)
                {

                }
            }

        }
        if(!list3.isEmpty()){
            for(String[] item:list3){
                String catalog=item[1];
                String subcat=item[2];
                for(String[] item2:list3){
                    if(item2[1].equals(catalog) && item2[2].equals(subcat))
                    {
                        deleteString.add("This is a file!");
                    }
                }

            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("Results", paths);
            req.setAttribute("Count", countFiles);
            req.setAttribute("Memory", memory);
            req.setAttribute("Delete",deleteString);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("show.jsp");
            requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title1");
        try {
            if ("form1".equals(req.getParameter("form"))) {
                paths = showFullPath(title);
                countInnerFiles(title);
                countMemory(title);
            }
            else if ("form2".equals(req.getParameter("form"))) {
                deleteFiles(title);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
