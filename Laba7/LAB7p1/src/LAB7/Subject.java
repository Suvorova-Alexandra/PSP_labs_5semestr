package LAB7;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Subject  extends AbstractTableModel {
    private int colnum=2;
    private int rownum;
    private String[] colNames =
            {
                    "subject_id", "subject_name"
            };

    private ArrayList<String[]> ResultSets;

    public Subject(ResultSet rs)
    {
        ResultSets=new ArrayList<>();
        try
        {
            while(rs.next())
            {
                String[] row =
                        {
                                rs.getString("subject_id"), rs.getString("subject_name")
                        };
                ResultSets.add(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in Subject");
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
