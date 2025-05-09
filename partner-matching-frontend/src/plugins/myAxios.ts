import axios from "axios";
import type { AxiosInstance } from "axios";

const isDev = import.meta.env.MODE === 'development';

const myAxios: AxiosInstance = axios.create({
    baseURL: isDev ? 'http://localhost:8080/api' : '线上地址',
});

myAxios.defaults.withCredentials = true; // 配置为true

myAxios.interceptors.request.use(function (config) {
    console.log('准备发请求', config)
    return config;
}, function (error) {
    return Promise.reject(error);
});

myAxios.interceptors.response.use(function (response) {
    console.log('收到你的响应', response)
    // 未登录则跳转到登录页
    if (response?.data?.code === 40100) {
        const redirectUrl = window.location.href;
        window.location.href = `/user/login?redirect=${redirectUrl}`;
    }
    return response.data;
}, function (error) {
    return Promise.reject(error);
});

export default myAxios;
