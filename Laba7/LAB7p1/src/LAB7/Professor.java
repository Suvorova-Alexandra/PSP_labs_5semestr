package LAB7;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Professor extends AbstractTableModel {
    private int colnum=4;
    private int rownum;
    private String[] colNames =
            {
                    "professor_id", "surname","professor_name","midname"
            };

    private ArrayList<String[]> ResultSets;

    public Professor(ResultSet rs)
    {
        ResultSets=new ArrayList<>();
        try
        {
            while(rs.next())
            {
                String[] row =
                        {
                                rs.getString("professor_id"), rs.getString("surname"),
                                rs.getString("professor_name"), rs.getString("midname")
                        };
                ResultSets.add(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in Professor");
        }
    }

    @Override
    public Object getValueAt(int rowindex, int columnindex)
    {
        String[] row = ResultSets.get(rowindex);
        return row[columnindex];
    }

    @Override
    public int getRowCount()
    {
        return ResultSets.size();
    }

    @Override
    public int getColumnCount()
    {
        return colnum;
    }

    @Override
    public String getColumnName(int param)
    {
        return colNames[param];
    }

}
