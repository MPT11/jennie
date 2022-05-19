package com.githrd.jennie.sql;

public class ReboradSQL {
    public final int SEL_ALL_LIST = 1001;
    public final int SEL_TOTAL_CNT = 1002;
    public final int SEL_WRITER_INFO = 1003;
    public final int SEL_REBOARD_INFO	= 1004;

    public final int INS_REBOARD = 3001;

    public String getSQL(int code){
        StringBuffer buff = new StringBuffer();
        switch (code) {
            case SEL_ALL_LIST:
                buff.append("select ");
                buff.append("    rno, rbno, upno, mno, id, body, savename, wdate, step ");
                buff.append("from ( ");
                buff.append("    select ");
                buff.append("        ROWNUM rno, rbno, upno, mno, id, body, savename, wdate, step ");
                buff.append("    from ( ");
                buff.append("        select ");
                buff.append("            rbno, nvl(upno,0) upno, mno, id, body, savename, wdate, (level - 1) step ");
                buff.append("        from ");
                buff.append("            reboard r, member m, AVATAR a ");
                buff.append("        where r.isshow = 'Y' ");
                buff.append("            AND rbmno = MNO ");
                buff.append("            AND avt = ano ");
                buff.append("        start with ");
                buff.append("            upno is null ");
                buff.append("        connect by ");
                buff.append("            prior rbno = upno ");
                buff.append("        order SIBLINGS BY ");
                buff.append("            wdate desc ");
                buff.append("        ) ");
                buff.append(") ");
                buff.append("where ");
                buff.append("    rno between ? and ? ");
                break;
            case SEL_TOTAL_CNT:
                buff.append("select ");
                buff.append("    COUNT(*) cnt ");
                buff.append("from ");
                buff.append("    reboard ");
                buff.append("where ");
                buff.append("    isshow = 'Y' ");
                break;
            case SEL_WRITER_INFO:
                buff.append("SELECT ");
                buff.append("    mno, savename ");
                buff.append("FROM ");
                buff.append("    member m, avatar a ");
                buff.append("WHERE ");
                buff.append("    m.isshow = 'Y' ");
                buff.append("    AND avt = ano ");
                buff.append("    AND id = ? ");
                break;
            case SEL_REBOARD_INFO:
                buff.append("SELECT ");
                buff.append("    rbno, body, mno, id, savename ");
                buff.append("FROM ");
                buff.append("	reboard r, member m, avatar a ");
                buff.append("WHERE ");
                buff.append("	r.isshow = 'Y' ");
                buff.append("	AND  rbno = ? ");
                buff.append("	AND  avt = ano ");
                buff.append("	AND  id = ? ");
                break;
            case INS_REBOARD:
                buff.append("insert into ");
                buff.append("    reboard (rbno, upno, rbmno, body) ");
                buff.append("values ( ");
                buff.append("    (select NVL(max(rbno)+1 , 100001) from reboard), ");
                buff.append("    ?, ?, ? ");
                buff.append(") ");
                break;
        }

        return buff.toString();
    }
}
