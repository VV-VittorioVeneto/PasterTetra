package com.vv.pastertetra;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import se.mickelus.tetra.effect.ItemEffect;
import se.mickelus.tetra.items.modular.ModularItem;

import net.pasterdream.procedures.*;

public class PTSkillandEffect {

    public static final ItemEffect moltengoldskill = ItemEffect.get("pastertetra:moltengoldskill");
    public static final ItemEffect moltengolddig = ItemEffect.get("pastertetra:moltengolddig");
    public static final ItemEffect netheritedig = ItemEffect.get("pastertetra:netheritedig");
    public static final ItemEffect moltendreamskill = ItemEffect.get("pastertetra:moltendreamskill");
    public static final ItemEffect tideskill = ItemEffect.get("pastertetra:tideskill");
    public static final ItemEffect grassskill = ItemEffect.get("pastertetra:grassskill");
    public static final ItemEffect desertskill = ItemEffect.get("pastertetra:desertskill");
    public static final ItemEffect[] Skills= new ItemEffect[]{netheritedig,moltengolddig,desertskill,grassskill,tideskill,moltendreamskill,moltengoldskill}; 
    //新技能一定从头部插入. New skills must be inserted at the top.

    public static final ItemEffect moltengoldeffect = ItemEffect.get("pastertetra:moltengoldeffect");
    public static final ItemEffect moltengoldburn = ItemEffect.get("pastertetra:moltengoldburn");
    public static final ItemEffect tideeffect = ItemEffect.get("pastertetra:tideeffect");
    public static final ItemEffect[] Blade_Effects= new ItemEffect[]{tideeffect,moltengoldeffect,moltengoldburn}; 
    //新效果一定从头部插入. New effects must be inserted at the top.

    public static final ItemEffect grasseffect = ItemEffect.get("pastertetra:grasseffect");
    public static final ItemEffect[] Fuller_Effects= new ItemEffect[]{grasseffect}; 
    //新效果一定从头部插入. New effects must be inserted at the top.

    //技能充能
    @SubscribeEvent
    public void onInteract(PlayerInteractEvent.RightClickItem event) {
        final Player player = event.getEntity();
        final LevelAccessor WorldIn = player.level();
        final ItemStack heldStack = player.getMainHandItem();
        if (!WorldIn.isClientSide()){
            //MainPastertetra.LOGGER.info("Begin C");
            if (heldStack.getItem() instanceof ModularItem item) {
                int skill_level = 0;
                int i = 0;
                for( i = 0 ; i < Skills.length ; i++ ){
                    skill_level <<= 1;
                    skill_level += item.getEffectLevel(heldStack, Skills[i]);
                }

                final int x = event.getPos().getX();
                final int y = event.getPos().getY();
                final int z = event.getPos().getZ();
                //MainPastertetra.LOGGER.info("When charged, skill level is "+ skill_level);

                //Switch case实现单选，避免多技能触发
                switch(skill_level){
                    case 0: break;
                    case 1: TruestMoltengoldSwordPr1Procedure.execute(WorldIn, x, y, z, player, heldStack);break;
                    case 2: DyedreamSwordPr1Procedure.execute(WorldIn, x, y, z, player, heldStack);break;
                    case 4: TrueTideSwordPr1Procedure.execute(WorldIn, x, y, z, player, heldStack);break;
                    case 8: TrueGrassSwordPr1Procedure.execute(WorldIn, x, y, z, player, heldStack);break;
                    case 16: TrueDesertSwordPr1Procedure.execute(WorldIn, x, y, z, player, heldStack);break;
                    case 32: MoltengoldPickaxePr0Procedure.execute(player, heldStack);break;
                    case 64: TrueMoltengoldPickaxePr0Procedure.execute(player, heldStack);break;
                }
                //新技能一定从末尾插入. New skills must be inserted st the end.
            }
        }
    }

    //技能攻击 效果攻击
    @SubscribeEvent
    public void attackEvent(LivingHurtEvent event) {
        final Entity source = event.getSource().getEntity();
        final Entity entity = event.getEntity();
        if ((source instanceof final Player player) && (entity != null)) {
            final LevelAccessor WorldIn = player.level();
            //if (!WorldIn.isClientSide()){
                //MainPastertetra.LOGGER.info("Begin A");
                final ItemStack heldStack = player.getMainHandItem();
                if (heldStack.getItem() instanceof ModularItem item) {
                    int skill_level = 0 , blade_level = 0 , fuller_level = 0;
                    int i = 0;
                    for( i = 0 ; i < Skills.length ; i++ ){
                        skill_level <<= 1;
                        skill_level += item.getEffectLevel(heldStack, Skills[i]);
                    }
                    for( i = 0 ; i < Blade_Effects.length ; i++ ){
                        blade_level <<= 1;
                        blade_level += item.getEffectLevel(heldStack, Blade_Effects[i]);
                    }
                    for( i = 0 ; i < Fuller_Effects.length ; i++ ){
                        fuller_level <<= 1;
                        fuller_level += item.getEffectLevel(heldStack, Fuller_Effects[i]);
                    }

                    //MainPastertetra.LOGGER.info("When attacking, skill level is " + skill_level);
                    //MainPastertetra.LOGGER.info("When attacking, blade effect level is " + blade_level);
                    //MainPastertetra.LOGGER.info("When attacking, fuller effect level is " + fuller_level);

                    final Double x = entity.position().x;
                    final Double y = entity.position().y;
                    final Double z = entity.position().z;

                    //Switch case实现单选，避免多技能触发
                    switch(blade_level){
                        case 0: break;
                        case 1: MoltengoldSwordPr0Procedure.execute(entity);break;
                        case 2: TrueMoltengoldSwordPr0Procedure.execute(entity);break;
                    }
                    //新效果一定从末尾插入. New effects must be inserted st the end.
                    switch(fuller_level){
                        case 0: break;
                        case 1: GrassSwordPr0Procedure.execute(WorldIn, entity, heldStack);break;
                    }
                    //新效果一定从末尾插入. New effects must be inserted st the end.
                    switch(skill_level){
                        case 0: break;
                        case 1: TruestMoltengoldSwordPr0Procedure.execute(WorldIn, x, y, z, entity, heldStack);break;
                        case 2: DyedreamSwordPr0Procedure.execute(WorldIn, x, y, z, entity, heldStack);break;
                        case 4: TrueTideSwordPr0Procedure.execute(WorldIn, x, y, z, entity, heldStack);break;
                        case 8: TrueGrassSwordPr0Procedure.execute(WorldIn, x, y, z, entity, heldStack);break;
                        case 16: TrueDesertSwordPr0Procedure.execute(WorldIn, x, y, z, entity, heldStack);break;
                    }
                    //新技能一定从末尾插入. New skills must be inserted st the end.
                }
            //}
        }
    }

    //手持效果
    @SubscribeEvent
    public void tickEvent(TickEvent.PlayerTickEvent event){
        final Entity player = event.player;
        final LevelAccessor WorldIn = player.level();
        final ItemStack heldStack = ((LivingEntity) player).getMainHandItem();
        if (!WorldIn.isClientSide()){
            if (heldStack.getItem() instanceof ModularItem item) { 
                final int level_tideeffect = item.getEffectLevel(heldStack, tideeffect);
                //MainPastertetra.LOGGER.info("When holding, tide effect level is " + level_tideeffect);

                if(level_tideeffect > 0)TideSwordPr0Procedure.execute(player);
            }
        }
    }
}
