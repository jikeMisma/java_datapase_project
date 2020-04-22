package pack01;
import java.util.List;

public class FromExcelToDb {
    public static void main(String[] args) {
        //得到表格中所有的数据
        List<Stu> listExcel=StuService.getAllByExcel("E:\\大二上课程设计\\数据库课设\\student_couse.xls");
        /*//得到数据库表中所有的数据
        List<Stu> listDb=StuService.getAllByDb();*/
        
        DBhelper db=new DBhelper();
        
        for (Stu stuEntity : listExcel) {
            int id=stuEntity.getId();
            if (!StuService.isExist(id)) {
                //不存在就添加
                String sql="insert into student (name,sex,num) values(?,?,?)";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+""};
                db.AddU(sql, str);
            }else {
                //存在就更新
                String sql="update student set name=?,sex=?,num=? where id=?";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+"",id+""};
                db.AddU(sql, str);
            }
        }
        System.out.println("数据更新成功！");
    }
}