package pack01;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

//实现Excel导入数据库核心类，读取Excel表中所有的数据，操作数据（查询、更新）
public class StuService {
    /**
     * 查询数据库中Student表中所有的数据
     */
    public static List<Stu> getAllByDb(){
        List<Stu> list = new ArrayList<Stu>();
        DBhelper db = new DBhelper();
        String sql = "select * from student";
        ResultSet rs = db.Search(sql, null);
        try {
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int num = rs.getInt("num");
                list.add(new Stu(id,name,sex,num));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 查询指定目录中Excel表格中所有数据
     * @param file为文件完整路径
     * @return
     */
    public static List<Stu> getAllByExcel(String file){
        List<Stu> list = new ArrayList<Stu>();
            try {
                Workbook rwb = Workbook.getWorkbook(new File(file));
                Sheet rs = rwb.getSheet("Test Shee 1"); //或者rwb.getSheet(0)
                int clos=rs.getColumns();//得到所有的列
                int rows=rs.getRows();//得到所有的行
                System.out.println("clos:"+clos+" rows:"+rows);
                for(int i=1;i<rows;i++){
                    int j=0;
                    //第一个是列数，第二个是行数
                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String name=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    String num=rs.getCell(j++, i).getContents();
                        
                    System.out.println("id:"+id+" name:"+name+" sex:"+sex+" num:"+num);
                    list.add(new Stu(Integer.parseInt(id), name, sex, Integer.parseInt(num)));                    
                }
            } catch (BiffException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return list;
    }
    
    /**
     * 通过id判断是否存在
     * @param id
     * @return
     */    
    public static boolean isExist(int id){
        try {
            DBhelper db=new DBhelper();
            ResultSet rs=db.Search("select * from student where id=?", new String[]{id+""});
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        /*List<Stu> all=getAllByDb();
        for (Stu stuEntity : all) {
            System.out.println(stuEntity.toString());
        }*/
        
        System.out.println(isExist(1));
        
    }
}