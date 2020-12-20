package LAB7;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Auditorium  extends AbstractTableModel {
    private int colnum=2;
    private int rownum;
    private String[] colNames =
            {
                    "class_id", "class_name"
            };

    private ArrayList<String[]> ResultSets;

    public Auditorium(ResultSet rs)
    {
        ResultSets=new ArrayList<>();
        try
        {
            while(rs.next())
            {
                String[] row =
                        {
                                rs.getString("class_id"), rs.getString("class_name")
                        };
                ResultSets.add(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in Auditorium");
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

