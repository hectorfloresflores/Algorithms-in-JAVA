package com.hectorflores;

public class ApplicationInstaller {
    public final Executable executable;
    ApplicationInstaller(Executable executable){
        this.executable = executable;
    }

    public static void main(String[] args) {
        ApplicationInstaller macos = new ApplicationInstaller(new Repository());
        Installer macosInstaller = macos.executable.manufactureInstaller(InstallerType.MACOS);

        ApplicationInstaller windows = new ApplicationInstaller(new Repository());
        Installer winInstaller = windows.executable.manufactureInstaller(InstallerType.WINEXE);
        Installer win32Installer = windows.executable.manufactureInstaller(InstallerType.WIN7);
        Installer win64Installer = windows.executable.manufactureInstaller(InstallerType.WIN10);

        ApplicationInstaller linux = new ApplicationInstaller(new Repository());
        Installer linuxInstaller = linux.executable.manufactureInstaller(InstallerType.LINUX);

        System.out.println(macosInstaller.toString());
        System.out.println(winInstaller.toString());
        System.out.println(win32Installer.toString());
        System.out.println(win64Installer.toString());
        System.out.println(linuxInstaller.toString());
    }
}



enum InstallerType {

    WIN7("WIN7"), WINEXE("WINEXE"),
    WIN10("WIN10"), LINUX("LINUX"),
    MACOS("MACOS"), UNDEFINED("");

    private String title;

    InstallerType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}


interface Installer{
    InstallerType getInstallerType();
}

class WindowsInstaller implements Installer {

    private InstallerType installerType;

    public WindowsInstaller(InstallerType installerType) {
        this.installerType = installerType;
    }

    @Override
    public String toString() {
        return "Operating System:  " + installerType;
    }

    @Override
    public InstallerType getInstallerType() {
        return this.installerType;
    }
}

class LinuxInstaller implements Installer {

    private InstallerType installerType;

    public LinuxInstaller(InstallerType installerType) {
        this.installerType = installerType;
    }

    @Override
    public String toString() {
        return "Operating System:  " + installerType;
    }

    @Override
    public InstallerType getInstallerType() {
        return this.installerType;
    }
}

class MacOSInstaller implements Installer {

    private InstallerType installerType;

    public MacOSInstaller(InstallerType installerType) {
        this.installerType = installerType;
    }

    @Override
    public String toString() {
        return "Operating System:  " + installerType;
    }

    @Override
    public InstallerType getInstallerType() {
        return this.installerType;
    }
}


interface Executable{

    Installer manufactureInstaller(InstallerType os);

}

class Repository implements Executable{

    @Override
    public Installer manufactureInstaller(InstallerType installerType) {
        switch (installerType){
            case WIN10:
                return new WindowsInstaller(installerType);
            case WIN7:
                return new WindowsInstaller(installerType);
            case WINEXE:
                return new WindowsInstaller(installerType);
            case MACOS:
                return new MacOSInstaller(installerType);
            case LINUX:
                return new LinuxInstaller(installerType);
            default:
                break;
        }
        return null;
    }
}

