export interface BadgePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
