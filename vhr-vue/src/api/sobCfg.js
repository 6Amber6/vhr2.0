import request from "@/utils/request.js";

//加载员工账套接口
export const loadSobCfg = (currentPage, currentSize) => {
    let url = '/api/salary/sobcfg/';
    if (currentPage != null && currentSize != null) {
        url = url + `?page=${currentPage}&size=${currentSize}`
    }
    return request({
        url: url,
        method: 'get'
    })
}

/**
 * 修改员工账套接口
 *
 * @param employId 员工Id
 * @param salaryId 工资Id
 * @method put http接口：get(请求资源数据)，post(涉及数据库改动的接口)，put(说明该接口修改数据)，delete(说明该接口删除数据)
 * @return 后端的返回结果
 */
export const updateSobCfg = (employId, salaryId) => {
    //请求参数url,前缀加api因为要识别端口转发
    let url = '/api/salary/sobcfg/';
    //其实也可以不要这个if判断直接执行方法里面的，因为后端没有默认值，所以这个接口参数必须要有值，不然会报错
    //TODO 自己把if去掉
    if (employId != null && salaryId != null) {
        url = url + `?eid=${employId}&sid=${salaryId}`
    }
    return request({
        url: url,
        method: 'put'
    })
}

