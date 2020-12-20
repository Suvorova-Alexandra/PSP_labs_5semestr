package LAB7;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Group extends AbstractTableModel {
    private int colnum=2;
    private int rownum;
    private String[] colNames =
            {
                    "group_id", "group_number"
            };

    private ArrayList<String[]> ResultSets;

    public Group(ResultSet rs)
    {
        ResultSets=new ArrayList<>();
        try
        {
            while(rs.next())
            {
                String[] row =
                        {
                                rs.getString("group_id"), rs.getString("group_number")
                        };
                ResultSets.add(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in Group");
        }
    }

    @Override
    public Object getValueAt(int rowindex, int columnindex)
    {System.out.println(rowindex+"+"+columnindex);
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
