package net.apptimystic.appoflife.data.checklist

import net.apptimystic.appoflife.data.task.Task

data class Checklist(val tasks: MutableList<Task> = mutableListOf())