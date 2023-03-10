package at.asna.asnabuild.scoreboard;


import org.bukkit.ChatColor;

public enum EntryName {
    ENTRY_0(0, ChatColor.DARK_PURPLE.toString()),
    ENTRY_1(1, ChatColor.DARK_GRAY.toString()),
    ENTRY_2(2, ChatColor.BOLD.toString()),
    ENTRY_3(3, ChatColor.DARK_RED.toString()),
    ENTRY_4(4, ChatColor.GRAY.toString()),
    ENTRY_5(5, ChatColor.DARK_GREEN.toString()),
    ENTRY_6(6, ChatColor.LIGHT_PURPLE.toString()),
    ENTRY_7(7, ChatColor.UNDERLINE.toString()),
    ENTRY_8(8, ChatColor.BLUE.toString()),
    ENTRY_9(9, ChatColor.MAGIC.toString()),
    ENTRY_10(10, ChatColor.GREEN.toString()),
    ENTRY_11(11, ChatColor.ITALIC.toString()),

    ENTRY_12(12, ChatColor.RED.toString()),

    ENTRY_13(13, ChatColor.STRIKETHROUGH.toString());

    private final int entry;
    private final String entryName;

    private EntryName(int entry, String entryName) {
        this.entry = entry;
        this.entryName = entryName;
    }

    public int getEntry() {
        return this.entry;
    }

    public String getEntryName() {
        return this.entryName;
    }
}
