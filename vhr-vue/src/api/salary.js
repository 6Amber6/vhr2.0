import request from "@/utils/request.js";


export const loadSalary = () => {
    let url = '/api/salary/sobcfg/salaries';
    return request({
        url: url,
        method: 'get'
    })
}

