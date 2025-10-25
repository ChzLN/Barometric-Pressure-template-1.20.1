package com.atmosphere.item;

import com.atmosphere.BarometricPressure;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

/**
 * Utility class for registering items.
 * 注册
 */
public class ModItems {

    // 气压传感器物品
    public static final Item BAROMETRIC_PRESSURE_SENSOR = registerItem("barometric_pressure_sensor", new Item(new Item.Settings()));
    // 气压传感器物品掉落物
    public static final Item BAROMETRIC_PRESSURE_SENSOR_DROP = registerItem("barometric_pressure_sensor_drop", new Item(new Item.Settings()));

    /**
     * 气压传感器物品 path 路径 可以用 “/” 方便分类
     * 关键特性
     * 命名空间路径
     * ID 为 "barometric/barometricPressure_path"
     * 使用斜杠 / 进行分类组织，将物品归类到 barometric 路径下
     * 注释说明
     * 明确指出可以通过 / 符号对物品进行分类管理
     * 这是一种方便整理和查找物品的组织方式
     * 实现方式
     * 通过 new Item(new Item.Settings()) 创建基础物品实例
     * 调用 registerItem 方法完成注册过程
     */
    public static final Item BAROMETRIC_PRESSURE_PATH = registerItem("barometric/barometric_pressure_path", new Item(new Item.Settings()));

    // 测压传感器物品
    public static final Item BAROMETRIC_PRESSURE_METER = registerItem("barometric_pressure_meter", new Item(new Item.Settings()));
    public static Item registerItems(String id, Item item){
        return Registry.register(Registries.ITEM,RegistryKey.of(Registries.ITEM.getKey(),new Identifier(BarometricPressure.MOD_ID,id)), item);
    }

    public static Item registerItem(String id, Item item){
        return Registry.register(Registries.ITEM,new Identifier(BarometricPressure.MOD_ID,id), item);
    }

    public static Item register(String id, Item item) {
        return register(new Identifier(BarometricPressure.MOD_ID,id), item);
    }

    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    /**
     * 辅助注册方法
     * 初始化 ModItems 类
     */
    public static void registerModItems() {

    }
}
