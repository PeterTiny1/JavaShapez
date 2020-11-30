package io.shapez.game;

public class KeyMappings {

    static int key(char key) {
        return Character.toUpperCase(key);
    }

    static class General {
        static class Confirm {
            static int keyCode = 13;
        } // enter

        static class Back {
            static int keyCode = 27;
            static boolean builtin = true;
        } // escape
    }

    static class Ingame {
        static class MenuOpenShop {
            static int keyCode = key('F');
        }

        static class MenuOpenStats {
            static int keyCode = key('G');
        }

        static class MenuClose {
            static int keyCode = key('Q');
        }

        static class ToggleHud {
            static int keyCode = 113;
        } // F2

        static class ExportScreenshot {
            static int keyCode = 114;
        } // F3PS

        static class ToggleFPSInfo {
            static int keyCode = 115;
        } // F4

        static class SwitchLayers {
            static int keyCode = key('E');
        }
    }

    static class Navigation {
        static class MapMoveUp {
            static int keyCode = key('W');
        }

        static class MapMoveRight {
            static int keyCode = key('D');
        }

        static class MapMoveDown {
            static int keyCode = key('S');
        }

        static class MapMoveLeft {
            static int keyCode = key('A');
        }

        static class MapMoveFaster {
            static int keyCode = 16;
        } //shift

        static class CenterMap {
            static int keyCode = 32;
        } // SPACE

        static class MapZoomIn {
            static int keyCode = 187;
            static boolean repeated = true;
        } // '+'

        static class MapZoomOut {
            static int keyCode = 189;
            static boolean repeated = true;
        } // '-'

        static class CreateMarker {
            static int keyCode = key('M');
        }
    }

    static class Buildings {
        // Primary Toolbar
        static class Belt {
            static int keyCode = key('1');
        }

        static class balancer {
            static int keyCode = key('2');
        }

        static class UndergroundBelt {
            static int keyCode = key('3');
        }

        static class Miner {
            static int keyCode = key('4');
        }

        static class Cutter {
            static int keyCode = key('5');
        }

        static class Rotater {
            static int keyCode = key('6');
        }

        static class Stacker {
            static int keyCode = key('7');
        }

        static class Mixer {
            static int keyCode = key('8');
        }

        static class Painter {
            static int keyCode = key('9');
        }

        static class Trash {
            static int keyCode = key('0');
        }

        // Sandbox
        static class ItemProducer {
            static int keyCode = key('L');
        }

        // Secondary toolbar
        static class Storage {
            static int keyCode = key('Y');
        }

        static class Reader {
            static int keyCode = key('U');
        }

        static class Lever {
            static int keyCode = key('I');
        }

        static class Filter {
            static int keyCode = key('O');
        }

        static class Display {
            static int keyCode = key('P');
        }

        // Wires toolbar
        static class Wire {
            static int keyCode = key('1');
        }

        static class WireTunnel {
            static int keyCode = key('2');
        }

        static class ConstantSignal {
            static int keyCode =
                    key('3');
        }

        static class LogicGate {
            static int keyCode = key('4');
        }

        static class VirtualProcessor {
            static int keyCode = key('5');
        }

        static class Analyzer {
            static int keyCode = key('6');
        }

        static class Comparator {
            static int keyCode = key('7');
        }

        static class Transistor {
            static int keyCode = key('8');
        }
    }

    static class Placement {
        static class Pipette {
            static int keyCode = key('Q');
        }

        static class RotateWhilePlacing {
            static int keyCode = key('R');
        }

        static class RotateInverseModifier {
            static int keyCode = 16;
        } // SHIFT

        static class CycleBuildingVariants {
            static int keyCode = key('T');
        }

        static class CycleBuildings {
            static int keyCode = 9;
        } // TAB

        static class SwitchDirectionLockSide {
            static int keyCode = key('R');
        }

        static class copyWireValue {
            static int keyCode = key('Z');
        }
    }

    static class MassSelect {
        static class MassSelectStart {
            static int keyCode = 17;
        } // CTRL

        static class MassSelectSelectMultiple {
            static int keyCode = 16;
        } // SHIFT

        static class MassSelectCopy {
            static int keyCode =
                    key('C');
        }

        static class MassSelectCut {
            static int keyCode = key('X');
        }

        static class ConfirmMassDelete {
            static int keyCode = 46;
        } // DEL

        static class PasteLastBlueprint {
            static int keyCode = key('V');
        }
    }

    static class PlacementModifiers {
        static class LockBeltDirection {
            static int keyCode = 16;
        } // SHIFT

        static class PlacementDisableAutoOrientation {
            static int keyCode = 17;
        } // CTRL

        static class PlaceMultiple {
            static int keyCode = 16;
        } // SHIFT

        static class placeInverse {
            static int keyCode = 18;
        } // ALT
    }
}
