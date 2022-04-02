package com.yixihan.programming_ability_1.day12;

/**
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * <p>
 * 请你实现 ParkingSystem 类：
 * <p>
 * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
 * bool addCar(int carType) 检查是否有 carType 对应的停车位。
 * carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一辆车只能停在  carType 对应尺寸的停车位中。
 * 如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 * <p>
 * 输入：
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * 输出：
 * [null, true, true, false, false]
 * <p>
 * 解释：
 * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
 * parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
 * parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
 * parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
 *
 * @author : yixihan
 * @create : 2022-03-22-10:00
 */
public class ParkingSystem {
    int[] parking = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        parking[0] = big;
        parking[1] = medium;
        parking[2] = small;
    }

    public boolean addCar(int carType) {
        if (parking[carType - 1] > 0) {
            parking[carType - 1]--;
            return true;
        } else {
            return false;
        }
    }
}
