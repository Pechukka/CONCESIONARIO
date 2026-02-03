package com.tradetune.app.ui.navigation;

/**
 * Enumeration of navigation sections in the application.
 * Represents the different main sections available in the UI.
 * 
 * Sections are organized into two groups:
 * - Sales module: VEHICLES, CLIENTS, PROPOSALS, SOLD
 * - Mechanics module: MY_JOBS, FINISHED
 */
public enum NavSection {
    /** Section for displaying available vehicles */
    VEHICLES,

    /** Section for managing clients */
    CLIENTS,

    /** Section for managing sales proposals */
    PROPOSALS,

    /** Section for viewing sold vehicles */
    SOLD,

    /** Section for mechanic's current jobs */
    MY_JOBS,

    /** Section for completed repair jobs */
    FINISHED
}
