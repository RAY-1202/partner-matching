import type {UserType} from "../models/user";

let currentUser: UserType;

// 添加本地缓存
let userCache = null;
let cacheExpiry = 0;
const CACHE_DURATION = 60000; // 缓存1分钟

const setCurrentUserState = (user: UserType) => {
    currentUser = user;
}

const getCurrentUserState = () : UserType => {
    return currentUser;
}

export const getCurrentUser = async () => {
    // 首先检查缓存
    const now = Date.now();
    if (userCache && cacheExpiry > now) {
        return userCache;
    }
    
    // 不在缓存中，从服务器获取
    const res = await myAxios.get('/user/current');
    if (res.data.code === 0) {
        userCache = res.data;
        cacheExpiry = now + CACHE_DURATION;
        setCurrentUserState(res.data);
        return res.data;
    }
    return null;
}

export {
    setCurrentUserState,
    getCurrentUserState,
}