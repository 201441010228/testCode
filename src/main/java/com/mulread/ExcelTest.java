package com.mulread;

/**
 * @Auther: 张扬
 * @Date: 2018/8/26 17:28
 * @Description:
 */
public class ExcelTest {

    public static void main(String args[]){

    }

   public static String getString(){
      return "insert overwrite table dmr.dmr_go_home_status_total partition (dt='{run_date}')\n"
              + "   select create_date,'',city_id,\n"
              + "        sum(driver_num) as driver_num,\n"
              + "        sum(order_num) as order_num,\n"
              + "        sum(estimated_Amount_all) as estimated_Amount_all,\n"
              + "        sum(over_num) as over_num,\n"
              + "        sum(over_order_amount) as over_order_amount,\n"
              + "        city_name,\n"
              + "        sum(order_cnt) as order_cnt,\n"
              + "        sum(push_order_cnt) as push_order_cnt,\n"
              + "        sum(bind_order_cnt)as bind_order_cnt,  --绑单量\n"
              + "        sum(over_order_cnt) as over_order_cnt,   --创建完成单\n"
              + "        sum(cancel_order_cnt) as cancel_order_cnt, --取消量\n"
              + "        sum(cancel_order_before) as cancel_order_before, --派前取消量\n"
              + "        sum(cancel_order_after) as cancel_order_after,   --派后取消量\n"
              + "        sum(system_cancel_order_before) as system_cancel_order_before,  --系统取消订单\n"
              + "        sum(user_cancel_order_before) as user_cancel_order_before,  --用户取消订单\n"
              + "        sum(user_cancel_order_before_30s) as user_cancel_order_before_30s, --用户30s取消订单量\n"
              + "        ''\n"
              + "        from(select substr(a.create_date,1,10) as create_date,      --日期\n"
              + "            a.order_city_id as city_id,                                      --城市id\n"
              + "            count(distinct case when go_home_status=1 then a.driver_id else null end) as driver_num,      --回家模式司机数\n"
              + "            count(distinct case when go_home_status=1 then a.order_no else null end) as order_num,                 --订单量\n"
              + "            sum(case when go_home_status=1 then a.estimated_amount else 0 end) as estimated_Amount_all,--订单预估金额\n"
              + "            0 as over_num,              --完成订单\n"
              + "            0 as over_order_amount,--完成流水\n"
              + "            a.order_city_name as city_name,\n"
              + "            count(distinct a.order_no) as order_cnt,  --下单量\n"
              + "            count(distinct a.order_no) - count(distinct case when (a.cancel_type = 300 and a.status =60) or a.status =10 then a.order_no else null end) as push_order_cnt,  --派单量\n"
              + "            count(distinct case when a.driver_id <> '0' then a.order_no else null end) as bind_order_cnt,  --绑单量\n"
              + "            count(distinct case when a.status>=44 and a.status<60 then a.order_no else null end) as over_order_cnt,   --创建完成单\n"
              + "            count(distinct case when a.cancel_type <> 300 and a.status =60 then order_no else null end) as  cancel_order_cnt, --取消量\n"
              + "            count(distinct case when a.cancel_type <> 300 and a.status =60 and driver_id = 0 then order_no else null end) as  cancel_order_before, --派前取消量\n"
              + "            count(distinct case when a.cancel_type <> 300 and a.status =60 and driver_id > 0 then order_no else null end) as cancel_order_after,   --派后取消量\n"
              + "            count(distinct case when a.cancel_type <> 300 and a.cancel_order_secs >=120 and a.status = 60 and driver_id = 0 then order_no else null end) as system_cancel_order_before,  --系统取消订单\n"
              + "            count(distinct case when a.cancel_type <> 300 and a.cancel_order_secs <120 and a.status = 60 and driver_id = 0 then order_no else null end) as user_cancel_order_before,  --用户取消订单\n"
              + "            count(distinct case when a.driver_id ='0' AND a.status=60 AND (a.cancel_type not in (11,19,20,36,300) or a.cancel_type is null) AND a.cancel_order_secs <=30 then a.order_no else null end) as user_cancel_order_before_30s --用户30s取消订单量\n"
              + "          from dws.dws_yc_orders_day a \n"
              + "          where dt='{partition_dt_date}' and t<=12 and order_city_id not in(70,74,86) and a.create_date>='{run_date}' and a.create_date<date_add('{run_date}',1)\n"
              + "          group by substr(a.create_date,1,10),a.order_city_id,a.order_city_name\n"
              + "        union all \n"
              + "        select substr(a.fact_end_date,1,10) as create_date,      --日期\n"
              + "            a.order_city_id as city_id,                                      --城市id\n"
              + "            0 as driver_num,      --回家模式司机数\n"
              + "            0 as order_num,                 --订单量\n"
              + "            0 as estimated_Amount_all,--订单预估金额\n"
              + "            count(case when go_home_status=1 and a.status>=44 and a.status<60 then a.order_no end) as over_num,              --完成订单\n"
              + "            sum(case when go_home_status=1 and a.status>=44 and a.status<60 then a.total_amount end) as over_order_amount,--完成订单金额\n"
              + "            a.order_city_name as city_name,\n"
              + "            0 as order_cnt,  --下单量\n"
              + "            0 as push_order_cnt,  --派单量\n"
              + "            0 as bind_order_cnt,  --绑单量\n"
              + "            0 as over_order_cnt,   --创建完成单\n"
              + "            0 as cancel_order_cnt, --取消量\n"
              + "            0 as cancel_order_before, --派前取消量\n"
              + "            0 as cancel_order_after,   --派后取消量\n"
              + "            0 as system_cancel_order_before,  --系统取消订单\n"
              + "            0 as user_cancel_order_before,  --用户取消订单\n"
              + "            0 as user_cancel_order_before_30s --用户30s取消订单量\n"
              + "          from dws.dws_yc_orders_day a \n"
              + "          where dt='{partition_dt_date}' and t<=12 and order_city_id not in(70,74,86) and a.fact_end_date>='{run_date}' and a.fact_end_date<date_add('{run_date}',1)\n"
              + "          group by substr(a.fact_end_date,1,10),substr(a.fact_end_date,12,2),a.order_city_id,a.order_city_name\n"
              + "        )t group by create_date,city_id,city_name;\n"
              + "    '''.format(run_date=run_date,partition_dt_date=partition_dt_date)\n";
   }
}
