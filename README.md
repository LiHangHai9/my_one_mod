# my_one_mod

李航海的 Minecraft Fabric 模组（MC 1.21.1）

## 内容

- **铁凿**（iron_chisel）：堆叠上限 8，可合成铁粉
- **铁粉**（iron_powder）：烧炼成铁锭
- **铁粉块**（iron_powder_block）：9 个铁粉合成，烧炼成铁块（省燃料+省经验）
- **高级工作台**（advanced_crafting_table）：带 GUI 的 3×3 合成台，支持自定义配方（材料+工具混放）

## 自定义配方格式

```json
{
  "type": "mod_one",
  "item": ["minecraft:iron_ore"],
  "tool_tier": "iron",
  "result": { "id": "raw_iron", "count": 2 }
}
```

- `item`：需要放入的材料
- `tool_tier`：需要的工具等级（wood/stone/iron/diamond/netherite）
- 合成后材料 -1，工具耐久 -1（工具不消失）

## 构建

```bash
gradle build
```

jar 输出在 `build/libs/my_one_mod-1.0.0.jar`

## 作者

LiHangHai × DouBao
