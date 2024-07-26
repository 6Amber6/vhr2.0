import request from "@/utils/request.js";


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

