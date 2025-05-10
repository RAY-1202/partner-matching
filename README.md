# Partner Matching System - 伙伴匹配系统

这是一个伙伴匹配系统，旨在帮助用户找到具有相似兴趣或技能的伙伴，并可以组建团队进行协作。

## 项目简介

本项目包含一个后端服务和一个前端应用程序。后端负责处理业务逻辑、数据存储和API接口，前端则提供用户交互界面。

## 技术栈

### 后端 (Backend)

-   **Java**: 主要编程语言
-   **Spring Boot**: 应用框架
-   **MyBatisPlus**: ORM 框架，简化数据库操作
-   **MySQL**: 关系型数据库
-   **Redis**: 内存数据存储，用于缓存和会话管理
-   **Redisson**: Redis Java 客户端，提供分布式锁等功能
-   **Maven**: 项目构建和依赖管理

### 前端 (Frontend)

-   **js**: 主要编程语言 


## 主要功能

-   **用户管理**:
    -   用户注册与登录
    -   用户信息查看与修改
    -   用户数据脱敏处理
    -   管理员权限区分
-   **伙伴匹配**:
    -   基于标签的用户搜索
    -   智能匹配算法推荐伙伴
-   **队伍管理**:
    -   创建队伍
    -   加入/退出队伍
    -   解散/删除队伍
    -   查看队伍列表（我创建的、我加入的、所有队伍）
    -   队伍信息修改
-   **数据管理**:
    -   通过 Excel 导入用户数据
-   **系统优化**:
    -   使用 Redis 进行数据缓存预热，提升访问速度
    -   定时任务调度


## 快速开始

### 后端

1.  **环境准备**:
    *   JDK 8+
    *   Maven 3.2+
    *   MySQL 5.7+
    *   Redis
2.  **数据库配置**:
    *   创建名为 `partner_matching_system` 的数据库。
    *   修改 `partner-matching-backend/partner-matching-system/src/main/resources/application-prod.yml`中的数据库和 Redis 连接信息。
3.  **启动项目**:
    *   进入 `partner-matching-backend/partner-matching-system/` 目录。
    *   运行 `mvn spring-boot:run` 或直接在 IDE 中运行 `PartnerMatchingSystemApplication.java`。

### 前端

1.  **环境准备**:
    *   Node.js 和 npm/yarn
2.  **安装依赖**:
    *   进入 `partner-matching-frontend/` 目录。
    *   运行 `npm install` 或 `yarn install`。
3.  **启动项目**:
    *   运行 `npm start` 或 `yarn start` (或其他相应的前端启动命令)。

## API 文档 (可选)

后端 API 遵循 RESTful 风格。可以考虑集成 Swagger 或 OpenAPI 来提供交互式 API 文档。

*(例如: 项目启动后，可访问 `http://localhost:8080/api/doc.html` 查看API文档)*


