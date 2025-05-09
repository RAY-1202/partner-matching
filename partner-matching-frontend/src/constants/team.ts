// 定义队伍状态枚举
export enum TeamStatusEnum {
  PUBLIC = 0,
  PRIVATE = 1,
  SECRET = 2,
}

// 定义状态对应的展示文本
export const teamStatusEnum: Record<number, string> = {
  [TeamStatusEnum.PUBLIC]: '公开',
  [TeamStatusEnum.PRIVATE]: '私有',
  [TeamStatusEnum.SECRET]: '加密',
};