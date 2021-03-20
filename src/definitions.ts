export interface BadgePlugin {
  /**
   * Get the badge count.
   * On Android and iOS, the badge count won't be lost after a reboot or app restart.
   * On the Web, the badge count is lost after closing the PWA.
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
