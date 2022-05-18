package com.githrd.jennie.sql;

public class ReboradSQL {
    public final int SEL_ALL_LIST = 1001;
    public final int SEL_TOTAL_CNT = 1002;

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
        }

        return buff.toString();
    }
}
