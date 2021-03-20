export interface BadgePlugin {
  /**
   * Get the badge count.
   * The badge count won't be lost after a reboot or app restart.
   *
   * Default: `0`.
   */
  get(): Promise<GetBadgeResult>;
  /**
   * Set the badge count.
   */
  set(options: SetBadgeOptions): Promise<void>;
  /**
   * Clear the badge count.
   */
  clear(): Promise<void>;
}

export interface GetBadgeResult {
  count: number;
}

export interface SetBadgeOptions {
  count: number;
}
