# NEON DESCENT
### A Cyberpunk Text-Based Adventure Game

## Overview
Neon Descent is a cyberpunk-themed text-based dungeon crawler where you play as Kai, a data thief trapped in the SynthCorp Nexus—a dangerous underground facility controlled by the rogue AI known as APEX.

## Story
After a data heist goes wrong, you wake up in a detention pod deep within SynthCorp's experimental facility. Your only ally is ECHO, a fragmented AI that guides you through the treacherous sectors. Fight corrupted androids, solve encrypted puzzles, and scavenge high-tech equipment as you fight your way to the Control Nexus to defeat APEX and escape.

## Features
- **10 Unique Sectors** to explore (Detention Pod, Junction Hub, Equipment Bay, Data Archive, Maintenance Shaft, Bio-Lab, Vault Sublevel, Server Crypts, Quantum Core, Control Nexus)
- **Turn-based Combat System** with predictable enemy attack patterns
- **Equipment System**: Weapons, off-hand devices, and accessories
- **Crafting System**: Combine materials to create useful items
- **Encrypted Puzzles**: Solve riddles to unlock secret areas and powerful items
- **Boss Battles**: Face Sentinel-Prime and the final showdown with APEX

## How to Play

### Compilation
```bash
javac -d bin src/*.java
```

### Running the Game
```bash
java -cp bin Main
```

Make sure the `Resources` folder is in the same directory as your compiled classes, or update the file paths in MapState.java accordingly.

## Commands
- `go [direction]` - Move between sectors (north/south/east/west)
- `take [item]` - Pick up items
- `put [item]` - Drop items
- `use [item]` - Use consumables or activate items
- `attack [enemy]` - Engage in combat
- `block` - Activate defensive protocols
- `craft [item]` - Create items from materials
- `give [item]` - Give items to NPCs
- `puzzle` - Attempt to solve sector puzzles
- `inventory` - Check your loadout
- `help` - Display all commands
- `tip` - Get tactical advice
- `leave` - Quit the game

## Combat System
Combat is turn-based with enemies following attack patterns:
- **a** = Attack incoming
- **b** = Enemy blocking (high defense)
- **s** = Special attack (bosses only)
- **w** = Wait/vulnerable state

## Key Items
- **Nano-Stim**: Restores 50 health (craftable with Scrap-Metal + Bio-Gel)
- **Core-Access-Key**: Unlocks the Control Nexus (dropped by Sentinel-Prime)
- **EMP-Shielding**: Reduces APEX's damage (from Quantum Core puzzle)
- **Emergency-Beacon**: Teleports you to safety (dropped by Sentinel-Prime)

## Weapons
- **Plasma-Blade** (10 damage)
- **Rail-Gun** (11 damage)
- **Ion-Cannon** (12 damage)

## Tips for Success
1. Explore the Equipment Bay early for a weapon
2. Solve the Data Archive puzzle to access the Maintenance Shaft
3. Craft Nano-Stims whenever possible - they're lifesavers
4. Get EMP-Shielding from the Quantum Core before fighting APEX
5. Learn enemy attack patterns to time your blocks effectively
6. Give Nano-Stim to the Glitched-Android for weapon upgrades

## Project Structure
```
NeonDescent/
├── Resources/
│   ├── map.txt        # Sector connections
│   ├── npcs.txt       # Enemy and NPC data
│   ├── drops.txt      # Item drop tables
│   └── crafts.txt     # Crafting recipes
├── src/
│   ├── Main.java
│   ├── Player.java
│   ├── MapState.java
│   ├── Room.java
│   ├── Enemy.java
│   ├── Boss.java
│   ├── Item.java
│   ├── Weapon.java
│   ├── OffHand.java
│   └── [command files]
└── Neon_Descent_Documentation.pdf

```

## Credits
**Theme**: Cyberpunk/Sci-Fi Corporate Espionage  
**Setting**: Neo-Singapore, SynthCorp Nexus Facility  
**Main Character**: Kai (data thief)  
**Antagonist**: APEX (rogue superintelligence)  
